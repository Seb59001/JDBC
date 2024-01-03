package Modele;

public class User {
    private int userId;
    private int userNumber;
    private String login;
    private String password;
    private String lastname;
    private String firstname;
    private String email;

    // Constructeur
    public User(int userId, int userNumber, String login, String password, String lastname, String firstname, String email) {
        this.userId = userId;
        this.userNumber = userNumber;
        this.login = login;
        this.password = password;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }

    // Méthodes getter
    public int getUserId() {
        return userId;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    // Méthodes setter
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
