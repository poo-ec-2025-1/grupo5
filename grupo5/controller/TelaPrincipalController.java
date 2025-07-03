package controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import view.Main;

public class TelaPrincipalController {

    @FXML
    private void irParaCadastroPlantas(ActionEvent event) {
        try {
            Main.mudarTela("CadastroPlanta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void irParaCarrinho(ActionEvent event) {
        try {
            // Quando criar a tela de compra, altere aqui
            Main.mudarTela("Comprar");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

