package test.page.message;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import data.login.User;
import generator.massage.RandomGeneratorMessage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSendMessageUser extends AbstractTest {

    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
    private final String message = RandomGeneratorMessage.getMessage();

    @BeforeEach
    public void login(){
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на отправку рандомного сообщения другу")
    @Timeout(5)//захотел попробовать таймаут просто
    @Test
    public void sendMessage() {
        assertTrue(mainPage.openMessageFriendOnMainPage()
                .sendMessage(message)
                .chekMessage(message));
    }

}
