import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    public static void salvarEndereco(Endereco endereco) {
        String sql = "INSERT INTO endereco (rua, numero, bairro, cidade, estado, cep) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, endereco.getRua());
            stmt.setString(2, endereco.getNumero());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getCidade());
            stmt.setString(5, endereco.getEstado());
            stmt.setString(6, endereco.getCep());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

