package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Node;

import java.io.IOException;

public class FormaDePagamentoController {

    @FXML
    private void handleCartaoDeCredito(ActionEvent event) {
        trocarTela(event, "/view/CartaoDeCredito.fxml", "Cartão de Crédito");
    }

    @FXML
    private void handlePix(ActionEvent event) {
        trocarTela(event, "/view/Pix.fxml", "Pix");
    }

    @FXML
    private void handleBoleto(ActionEvent event) {
        trocarTela(event, "/view/Boleto.fxml", "Boleto");
    }

    private void trocarTela(ActionEvent event, String caminhoFXML, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(caminhoFXML));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 360, 640));
            stage.setTitle(titulo);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
