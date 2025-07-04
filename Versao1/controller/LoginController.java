import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import javafx.event.Event;

/**
 * Controlador da tela de login.
 * Lida com as ações dos botões e com a lógica de autenticação via classe Login.
 */
public class LoginController {
    // Referências para a View e Stage
    private LoginView view;
    private Stage stage;

    // Modelo de autenticação
    private Login login;

    // Elementos da interface (devem ter os mesmos fx:id do FXML)
    public TextField loginEmail;
    public PasswordField loginSenha;
    public Label loginMensagem;

    // Construtor
    public LoginController() {
        this.stage = new Stage();
        this.view = new LoginView();
        this.view.setController(this);

        this.login = new Login(); // cria o "modelo" de autenticação
    }

    // Inicializa a interface
    public void iniciar() throws Exception {
        this.view.start(this.stage);
    }

    // Método chamado quando o botão "Entrar" é clicado
    public void botaoEntrarClicado(Event e) {
        String email = loginEmail.getText();
        String senha = loginSenha.getText();

        if (login.autenticar(email, senha)) {
            loginMensagem.setText("Login realizado com sucesso!");
            loginMensagem.setStyle("-fx-text-fill: green");
        } else {
            loginMensagem.setText("Credenciais inválidas");
            loginMensagem.setStyle("-fx-text-fill: red");
        }
    }

    // Método chamado quando o botão "Criar Conta" é clicado
    public void botaoCriarContaClicado(Event e) {
        loginMensagem.setText("A funcionalidade ainda não foi implementada.");
        loginMensagem.setStyle("-fx-text-fill: blue");
    }
}

