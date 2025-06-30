/**
 * Classe modelo que representa a lógica de autenticação.
 * Aqui os dados são simulados, mas futuramente pode ser conectada a um banco de dados.
 */
public class Login {
    private String emailCorreto;
    private String senhaCorreta;

    /**
     * Construtor com dados fixos para simular o "banco".
     */
    public Login() {
        this.emailCorreto = "grupo5@gmail.com";
        this.senhaCorreta = "1234";
    }

    /**
     * Verifica se os dados estão corretos.
     * @param email E-mail digitado
     * @param senha Senha digitada
     * @return true se estiverem corretos, false caso contrário
     */
    public boolean autenticar(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false; // campos vazios
        }

        return email.equals(this.emailCorreto) && senha.equals(this.senhaCorreta);
    }
}
