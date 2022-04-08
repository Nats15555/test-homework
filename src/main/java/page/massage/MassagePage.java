package page.massage;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import block.MailBlock;
import data.massage.Massage;

public class MassagePage implements AbstractMassagePage{

    private final WebDriver driver;
    private final MailBlock mailBlock;

    public MassagePage(WebDriver driver) {
        this.driver = driver;
        this.mailBlock = new MailBlock(driver);
    }

    public MassagePage openDialog(String identification){
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[contains(@data-item-id,'" + identification + "')]")).click();
        return this;
    }

    public MassagePage sendMassage(String massage){//отправка сообщения
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[@data-l=\"t,msgInput\"]")).sendKeys(massage);
        driver.findElement(By.xpath("//*[@id=\"msg_layer\"]//*[@data-l=\"t,sendButton\"]")).click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return this;
    }

    public boolean chekMassage(String massage){
        Set<Massage> massages = mailBlock.getUserMassages();
        for(Massage tempMassage: massages){
            if(tempMassage.getMassageContent().contains(massage)){
                return true;
            }
        }
        return false;
    }

}
