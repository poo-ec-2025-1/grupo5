import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

public class CartaoDeCreditoController {

    @FXML
    private TextField numeroCartaoField;

    @FXML
    private TextField nomeCartaoField;

    @FXML
    private TextField validadeField;

    @FXML
    private TextField cvvField;

    @FXML
    private RadioButton parcela1, parcela2, parcela3, parcela4;

    @FXML
    private Button botaoSalvar;

    private ToggleGroup grupoParcelas;

    @FXML
    private void initialize() {
        grupoParcelas = new ToggleGroup();
        parcela1.setToggleGroup(grupoParcelas);
        parcela2.setToggleGroup(grupoParcelas);
        parcela3.setToggleGroup(grupoParcelas);
        parcela4.setToggleGroup(grupoParcelas);
    }

    @FXML
    private void salvarDados(ActionEvent event) {
        String numero = numeroCartaoField.getText();
        String nome = nomeCartaoField.getText();
        String validade = validadeField.getText();
        String cvv = cvvField.getText();

        String parcelas = "";
        RadioButton selecionado = (RadioButton) grupoParcelas.getSelectedToggle();
        if (selecionado != null) {
            parcelas = selecionado.getText();
        }

        if (numero.isEmpty() || nome.isEmpty() || validade.isEmpty() || cvv.isEmpty() || parcelas.isEmpty()) {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Erro");
            alerta.setHeaderText("Campos vazios");
            alerta.setContentText("Preencha todos os campos e selecione o número de parcelas.");
            alerta.show();
            return;
        }

        salvarNoBanco(numero, nome, validade, cvv, parcelas);
        abrirTelaCompraFinalizada();
    }

    private void salvarNoBanco(String numero, String nome, String validade, String cvv, String parcelas) {
        String url = "jdbc:sqlite:meubanco.db";

        String criarTabela = """
            CREATE TABLE IF NOT EXISTS cartao (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                numero TEXT,
                nome TEXT,
                validade TEXT,
                cvv TEXT,
                parcelas TEXT
            );
        """;

        String inserir = "INSERT INTO cartao (numero, nome, validade, cvv, parcelas) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            stmt.execute(criarTabela);

            PreparedStatement pstmt = conn.prepareStatement(inserir);
            pstmt.setString(1, numero);
            pstmt.setString(2, nome);
            pstmt.setString(3, validade);
            pstmt.setString(4, cvv);
            pstmt.setString(5, parcelas);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void abrirTelaCompraFinalizada() {
    try {
        Parent root = FXMLLoader.load(getClass().getResource("CompraFinalizada.fxml"));
        Stage stage = (Stage) botaoSalvar.getScene().getWindow();
        stage.setScene(new Scene(root, 360, 640));
        stage.setTitle("Compra Finalizada");
        stage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}

