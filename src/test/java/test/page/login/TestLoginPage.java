package test.page.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

public class TestLoginPage extends AbstractTest {

    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();

    @BeforeEach
    public void login(){
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на авторизацию")
    @Test
    public void authorization() {
        assertTrue(mainPage.isAuth(user));
    }
}

