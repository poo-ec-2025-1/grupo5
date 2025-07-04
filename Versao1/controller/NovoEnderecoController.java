import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class NovoEnderecoController {

    @FXML private TextField ruaField, numeroField, bairroField, cidadeField, estadoField, cepField;

    @FXML
    private void handleSalvar(ActionEvent event) throws IOException {
        Endereco endereco = new Endereco(
                ruaField.getText(),
                numeroField.getText(),
                bairroField.getText(),
                cidadeField.getText(),
                estadoField.getText(),
                cepField.getText()
        );

        EnderecoDAO.salvarEndereco(endereco);

        Parent root = FXMLLoader.load(getClass().getResource("FormaDePagamento.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Forma de Pagamento");
        stage.setScene(new Scene(root, 360, 640));
        stage.show();
    }
}
