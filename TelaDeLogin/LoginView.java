import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

/**
 * View (interface gráfica) da tela de login.
 */
public class LoginView extends Application {
    private FXMLLoader loader;
    private URL url;

    public LoginView() {
        this.loader = new FXMLLoader();
        try {
            this.url = new File("teladlogin.fxml").toURI().toURL();
        } catch (Exception e) {
            System.out.println("Erro ao carregar o FXML: " + e);
        }
        this.loader.setLocation(this.url);
    }

    // Permite configurar manualmente o controller
    public void setController(LoginController controller) {
        this.loader.setController(controller);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = loader.load(); // carrega o FXML
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tela de Login");
        primaryStage.show();
    }
}
