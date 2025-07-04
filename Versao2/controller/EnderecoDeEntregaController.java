package controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnderecoDeEntregaController implements Initializable {

    @FXML
    private RadioButton meuEnderecoButton;

    @FXML
    private RadioButton adicionarEnderecoButton;

    private ToggleGroup enderecoToggleGroup;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        enderecoToggleGroup = new ToggleGroup();
        meuEnderecoButton.setToggleGroup(enderecoToggleGroup);
        adicionarEnderecoButton.setToggleGroup(enderecoToggleGroup);
    }

    @FXML
    private void handleMeuEndereco(ActionEvent event) {
        trocarTela(event, "/view/FormaDePagamento.fxml", "Forma de Pagamento");
    }

    @FXML
    private void handleAdicionarEndereco(ActionEvent event) {
        trocarTela(event, "NovoEndereco.fxml", "Novo Endereço");
    }

    private void trocarTela(ActionEvent event, String fxml, String titulo) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root, 360, 640));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}