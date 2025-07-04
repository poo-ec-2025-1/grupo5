package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega a view da planta
        Parent root = FXMLLoader.load(getClass().getResource("/view/cadastro.fxml"));

        Scene scene = new Scene(root);
        primaryStage.setTitle("Cadastro de Plantas");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
