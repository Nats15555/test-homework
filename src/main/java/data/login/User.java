package data.login;

/**
 * Класс описывает пользователя
 */
public class User {
    private String login;
    private String password;
    private String nameAndSurname;

    /**
     * Конструктор для создания объекта
     *
     * @param login
     * @param password
     * @param nameAndSurname
     */
    public User(String login, String password, String nameAndSurname) {
        this.login = login;
        this.password = password;
        this.nameAndSurname = nameAndSurname;
    }

    /**
     * Конструктор без параметров, что бы использовать его совместно с UserBuild
     */
    public User() {
    }

    /**
     * Паттерн Builder
     */
    public static class UserBuilder {
        private User user;

        /**
         * Конструктор для создания Builder
         */
        public UserBuilder() {
            this.user = new User();
        }

        /**
         * Создает User с параметром login
         *
         * @param login
         * @return
         */
        public UserBuilder withLogin(String login){
            user.login = login;
            return this;
        }

        /**
         * Создает User с параметром password
         *
         * @param password
         * @return
         */
        public UserBuilder withPassword(String password){
            user.password = password;
            return this;
        }

        /**
         * Создает User с параметром nameAndSurname
         *
         * @param nameAndSurname
         * @return
         */
        public UserBuilder withNameAndSurname(String nameAndSurname){
            user.nameAndSurname = nameAndSurname;
            return this;
        }

        /**
         * Возвращает User с определенными параметрами, которые мы ему задали ранее
         *
         * @return
         */
        public User build(){
            return user;
        }
    }

    /**
     * Получаем логин
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     * Меняем логин
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Получаем пароль
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Меняем пароль
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Получаем имя и фамилию
     *
     * @return
     */
    public String getNameAndSurname() {
        return nameAndSurname;
    }

    /**
     * Меняем имя и фамилию
     *
     * @param nameAndSurname
     */
    public void setNameAndSurname(String nameAndSurname) {
        this.nameAndSurname = nameAndSurname;
    }
}
