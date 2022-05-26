package test.page.idea;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import generator.massage.GeneratorMessage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddNewEmotionToTheWall extends AbstractTest {

    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
    private final String message = new GeneratorMessage().random();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на поделиться своим настроением в идеи дня")
    @Test
    public void addEmotion() {
        assertTrue(mainPage.openIdeaPage().shareMood().addNewMessageWithEmotion(message).chekCorrectExecution());
    }

}
