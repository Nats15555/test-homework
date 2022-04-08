package test.send.massage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import generator.massage.RandomGeneratorMassage;
import test.AbstractTest;

public class TestSendMassageSputnik extends AbstractTest{

    //это частный случай уже с моими данными (тут у меня не было ботов и тестировал на спутнике) сюда не надо смотерть)

    String massage = RandomGeneratorMassage.getMassage();

    @Before
    public void start(){
        driver.get("https://ok.ru");
        mainPage = loginPage.doLogin("79697115322","doom800300");
    }

    @Test
    public void sendMassage() {
        Assert.assertTrue(mainPage.openMassagePageUseTopMenu()
                .openDialog("-82680697280182")
                .sendMassage(massage)
                .chekMassage(massage));
        driver.close();
    }
}
