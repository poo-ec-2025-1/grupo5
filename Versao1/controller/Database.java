import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:enderecos.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS endereco (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "rua TEXT NOT NULL," +
                     "numero TEXT NOT NULL," +
                     "bairro TEXT NOT NULL," +
                     "cidade TEXT NOT NULL," +
                     "estado TEXT NOT NULL," +
                     "cep TEXT NOT NULL);";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


