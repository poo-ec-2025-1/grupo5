import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class FormaDePagamentoController {

    @FXML
    private void handleCartaoDeCredito(ActionEvent event) {
        trocarTela(event, "CartaoDeCredito.fxml", "Cartão de Crédito");
    }

    @FXML
    private void handlePix(ActionEvent event) {
        trocarTela(event, "Pix.fxml", "Pix");
    }

    @FXML
    private void handleBoleto(ActionEvent event) { // CORRIGIDO aqui
        trocarTela(event, "Boleto.fxml", "Boleto");
    }

    private void trocarTela(ActionEvent event, String fxml, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, 360, 640));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
