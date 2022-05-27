package test.language;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LanguageTest extends AbstractTest {
    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на смену языка")
    @Test
    public void addGroup() {
        assertTrue(mainPage.clickLanguageList().clickLanguageEng().chekLanguage("English"));
        mainPage.clickLanguageList().clickLanguageRu();
    }
}
