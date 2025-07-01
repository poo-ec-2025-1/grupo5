import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.io.IOException;

public class CompraFinalizadaController {

    @FXML
    private void voltarParaInicio(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("EnderecoDeEntrega.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 360, 640));
            stage.setTitle("Endereço de Entrega");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
