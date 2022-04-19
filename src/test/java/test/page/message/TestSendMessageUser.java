package test.page.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import generator.massage.RandomGeneratorMessage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSendMessageUser extends AbstractTest {

    private final String message = RandomGeneratorMessage.getMessage();

    @DisplayName("Тест на отправку рандомного сообщения другу")
    @Timeout(5)//захотел попробовать таймаут просто
    @Test
    public void sendMessage() {
        assertTrue(mainPage.openMessageFriendOnMainPage()
                .sendMessage(message)
                .chekMessage(message));
    }

}
