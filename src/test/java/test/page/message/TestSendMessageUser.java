package test.page.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import data.login.User;
import generator.massage.GeneratorMessage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSendMessageUser extends AbstractTest {
    private final String message = new GeneratorMessage().random();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на отправку рандомного сообщения другу")
    @Timeout(5)
    @Test
    public void sendMessage() {
        assertTrue(mainPage.openMessageFriendOnMainPage()
                .sendMessage(message)
                .chekMessage(message));
    }

}
