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

    public User() {
    }

    public static class UserBuilder {
        private User user;

        public UserBuilder() {
            this.user = new User();
        }

        public UserBuilder withLogin(String login){
            user.setLogin(login);
            return this;
        }

        public UserBuilder withPassword(String password){
            user.setPassword(password);
            return this;
        }

        public UserBuilder withNameAndSurname(String nameAndSurname){
            user.setNameAndSurname(nameAndSurname);
            return this;
        }

        public User build(){
            return user;
        }
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
