package model;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import model.Planta;
import model.Database;

public class PlantaRepositorio {

    private static Database database;
    private static Dao<Planta, Integer> dao;
    private List<Planta> loadedPlantas;
    private Planta loadedPlanta;

    public PlantaRepositorio(Database db) {
        PlantaRepositorio.setDatabase(db);
        loadedPlantas = new ArrayList<Planta>();
    }

    public static void setDatabase(Database db) {
        PlantaRepositorio.database = db;
        try {
            dao = DaoManager.createDao(database.getConnection(), Planta.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Planta.class);
        } catch (SQLException e) {
            System.out.println("Erro ao configurar o banco de dados:");
            e.printStackTrace();
        }
    }

    public Planta adicionar(Planta planta) {
        int nrows = 0;
        try {
            nrows = dao.create(planta);
            if ( nrows == 0 )
                throw new SQLException("Erro: planta não foi salva no banco de dados.");
            this.loadedPlanta = planta;
            loadedPlantas.add(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return planta;
    }

    public void atualizar(Planta planta) {
        try {
            dao.update(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletar(Planta planta) {
        try {
            dao.delete(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Planta buscarPorId(int id) {
        try {
            this.loadedPlanta = dao.queryForId(id);
            if (this.loadedPlanta != null) {
                this.loadedPlantas.add(this.loadedPlanta);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedPlanta;
    }

    public List<Planta> listarTodas() {
        try {
            this.loadedPlantas = dao.queryForAll();
            if (this.loadedPlantas.size() != 0)
                this.loadedPlanta = this.loadedPlantas.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedPlantas;
    }
}
