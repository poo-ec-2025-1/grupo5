package controller;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import view.Main;

public class LoginController {

    @FXML
    public void entrar(ActionEvent event) {
        try {
            Main.mudarTela("TelaPrincipal");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

