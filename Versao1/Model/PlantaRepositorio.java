package repository;

import model.Planta;
import model.Database;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PlantaRepositorio {
    private static Database database;
    private static Dao<Planta, Integer> dao;
    private List<Planta> listaPlantas = new ArrayList<>();

    public PlantaRepositorio(Database database) {
        PlantaRepositorio.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Planta.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Planta.class);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Planta create(Planta planta) {
        try {
            dao.create(planta);
            listaPlantas.add(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return planta;
    }

    public List<Planta> loadAll() {
        try {
            listaPlantas = dao.queryForAll();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listaPlantas;
    }
}
