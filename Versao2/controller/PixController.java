package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class PixController {

    @FXML private ImageView qrCodeImageView;
    @FXML private Button botaoSalvar;
    @FXML private Label statusLabel;

    @FXML
    private void confirmarPagamentoPix(ActionEvent event) {
        // Simulação de pagamento
        statusLabel.setText("Pagamento confirmado!");

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/CompraFinalizada.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 360, 640));
            stage.setTitle("Compra Finalizada");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

