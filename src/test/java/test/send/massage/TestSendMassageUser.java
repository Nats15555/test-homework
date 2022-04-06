package test.send.massage;

import org.junit.Assert;
import org.junit.Test;

import generator.massage.RandomGeneratorMassage;
import test.AbstractTest;

public class TestSendMassageUser extends AbstractTest{

    private final String massage = RandomGeneratorMassage.getMassage();//можно как тро

    @Test
    public void sendMassage() {
        Assert.assertTrue(mainPage.openMassageFriendOnMainPage()
                .sendMassage(massage)
                .chekMassage(massage));
        driver.close();
    }

}
