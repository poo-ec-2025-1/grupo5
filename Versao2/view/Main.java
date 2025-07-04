package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        mudarTela("Login");
        stage.setTitle("Marketplace de Plantas");
        stage.show();
    }

    public static void mudarTela(String nomeTela) throws Exception {
        Parent root = null;

        switch (nomeTela) {
            case "Login":
                root = FXMLLoader.load(Main.class.getResource("/view/Login.fxml"));
                break;
            case "TelaPrincipal":
                root = FXMLLoader.load(Main.class.getResource("/view/TelaPrincipal.fxml"));
                break;
            case "CadastroPlanta":
                root = FXMLLoader.load(Main.class.getResource("/view/CadastroPlanta.fxml"));
                break;
            case "Comprar":
                root = FXMLLoader.load(Main.class.getResource("/view/Compra.fxml"));
                break;

        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
