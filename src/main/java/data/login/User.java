package data.login;

public class User {
    private String login;
    private String password;
    private String nameAndSurname;

    public User(String login, String password, String nameAndSurname) {
        this.login = login;
        this.password = password;
        this.nameAndSurname = nameAndSurname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNameAndSurname() {
        return nameAndSurname;
    }

    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }
}
