package test.page.group;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestAddGroup extends AbstractTest {
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
