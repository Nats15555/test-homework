package test.send.massage;

import org.junit.Assert;
import org.junit.Test;

import generator.massage.RandomGeneratorMassage;
import test.AbstractTest;

public class TestSendMassageUser extends AbstractTest implements TestSendMassage {

    private final String massage = RandomGeneratorMassage.getMassage();//можно как тро

    @Test
    public void sendMassage() {
        boolean resultTest = mainPage.openMassageFriendOnMainPage()
                .sendMassage(massage)
                .chekMassage(massage);
        Assert.assertTrue(resultTest);
        driver.close();
    }

}
