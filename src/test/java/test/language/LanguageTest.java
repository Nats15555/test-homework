package test.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest extends AbstractTest {
    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на смену языка")
    @Test
    public void c() {
        assertTrue(mainPage.clickLanguageList().clickLanguageEng().chekLanguage("English"));
        mainPage.clickLanguageList().clickLanguageRu();
    }
}
