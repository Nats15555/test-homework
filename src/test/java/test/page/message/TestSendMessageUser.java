package test.page.message;

import org.junit.Assert;
import org.junit.Test;

import generator.massage.RandomGeneratorMessage;
import test.AbstractTest;

public class TestSendMessageUser extends AbstractTest{

    private final String message = RandomGeneratorMessage.getMessage();

    @Test
    public void sendMassage() {
        Assert.assertTrue(mainPage.openMessageFriendOnMainPage()
                .sendMessage(message)
                .chekMessage(message));
    }

}
