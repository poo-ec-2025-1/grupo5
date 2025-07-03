package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Stage;
import model.SessaoCompra;

public class CompraFinalizadaController {

    @FXML
    private void voltarParaInicio(ActionEvent event) {
        // Limpa o carrinho após a compra ser concluída
        SessaoCompra.getInstancia().limpar();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("/view/TelaPrincipal.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root, 700, 500)); // ajuste se sua TelaPrincipal tiver outro tamanho
            stage.setTitle("Tela Principal");
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
