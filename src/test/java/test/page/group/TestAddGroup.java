package test.page.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddGroup extends AbstractTest {
    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на возможность подписаться на группу")
    @Test
    public void addGroup() {
        assertTrue(mainPage.openGroupPage().subscribeToGroup().checkSubscribeToGroup());
    }
}
