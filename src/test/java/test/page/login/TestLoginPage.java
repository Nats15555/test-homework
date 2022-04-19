package test.page.login;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import test.AbstractTest;

public class TestLoginPage extends AbstractTest {

    @DisplayName("Тест на авторизацию")
    @Test
    public void authorization() {
        assertTrue(mainPage.isAuth(user));
    }

    @Test
    @Disabled("Не использовать данны тест, он был нужен на ранних версиях проекта")
    public void authorizationAndLogOutTest() {
        assertTrue(mainPage.logOut().intoLoginPage());
    }
}

