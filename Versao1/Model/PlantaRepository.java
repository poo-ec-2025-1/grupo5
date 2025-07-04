import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.Dao;
import java.sql.SQLException;
import com.j256.ormlite.table.TableUtils;
import java.util.List;
import java.util.ArrayList;


public class PlantaRepository
{
    private static Database database;
    private static Dao<Planta, Integer> dao;
    private List<Planta> loadedPlantas;
    private Planta loadedPlanta;

    public PlantaRepository(Database database) {
        PlantaRepository.setDatabase(database);
        loadedPlantas = new ArrayList<Planta>();
    }

    public static void setDatabase(Database database) {
        PlantaRepository.database = database;
        try {
            dao = DaoManager.createDao(database.getConnection(), Planta.class);
            TableUtils.createTableIfNotExists(database.getConnection(), Planta.class);
        } catch(SQLException e) {
            System.out.println(e);
        }
    }

    public Planta create(Planta planta) {
        try {
            int nrows = dao.create(planta);
            if (nrows == 0)
                throw new SQLException("Erro: objeto não salvo.");
            this.loadedPlanta = planta;
            loadedPlantas.add(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return planta;
    }

    public void update(Planta planta) {
        try {
            dao.update(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void delete(Planta planta) {
        try {
            dao.delete(planta);
            loadedPlantas.remove(planta);
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public Planta loadFromId(int id) {
        try {
            this.loadedPlanta = dao.queryForId(id);
            if (this.loadedPlanta != null)
                loadedPlantas.add(this.loadedPlanta);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedPlanta;
    }

    public List<Planta> loadAll() {
        try {
            this.loadedPlantas = dao.queryForAll();
            if (!this.loadedPlantas.isEmpty())
                this.loadedPlanta = this.loadedPlantas.get(0);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return this.loadedPlantas;
    }
}
