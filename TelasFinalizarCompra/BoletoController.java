import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BoletoController {

    @FXML
    private Button botaoSalvar;

    @FXML
    private Label statusLabel;

    @FXML
    public void salvarDados() {
        statusLabel.setText("Verificando pagamento...");

        PauseTransition pause = new PauseTransition(Duration.seconds(2));
        pause.setOnFinished(event -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("CompraFinalizada.fxml"));
                Stage stage = (Stage) botaoSalvar.getScene().getWindow();
                stage.setScene(new Scene(root, 360, 640));
                stage.setTitle("Compra Finalizada");
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
                statusLabel.setText("Erro ao carregar a próxima tela.");
            }
        });

        pause.play();
    }
}
