package part4.shop;

public class User {
    private final String login;
    private final String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    /** Проверка введённых логина и пароля. */
    public boolean checkCredentials(String login, String password) {
        return this.login.equals(login) && this.password.equals(password);
    }
}
