// MainApp.java

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            Database.criarTabela();
            Parent root = FXMLLoader.load(getClass().getResource("EnderecoDeEntrega.fxml"));
            primaryStage.setTitle("Minha Aplicação JavaFX");
            primaryStage.setScene(new Scene(root, 360, 640));
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao carregar a tela inicial.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

