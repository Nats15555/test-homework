package test.page.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

public class TestLoginPage extends AbstractTest {

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на авторизацию")
    @Test
    public void authorization() {
        assertTrue(mainPage.isAuth(user));
    }
}

