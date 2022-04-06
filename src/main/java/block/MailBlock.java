package block;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.massage.Massage;

public class MailBlock {
    private final WebElement mainXpathBlock;// веб элепмент обращаться вебэлемент.фаинт

    public MailBlock(WebDriver driver) {
        mainXpathBlock = driver.findElement(By.xpath("//*[@id=\"msg_layer\"]"));
    }

    public Set<Massage> getUserMassages() {
        List<WebElement> allMassage = mainXpathBlock.findElements(By.xpath("//*[contains(@class,\"group\")]"));
        Set<Massage> massageList = new HashSet<>();
        for (WebElement temp : allMassage) {
            String[] massageFields = temp.getText().split("\\n");

            if (massageFields.length == 3) {
                massageList.add(new Massage(massageFields[0], massageFields[1], massageFields[2]));
                continue;
            }

            Massage massage = new Massage(massageFields[0], "", "");
            StringBuilder massageContent = new StringBuilder();
            for (int i = 1; i < massageFields.length; i++) {
                if (massageFields[i].length() == 5 && massageFields[i].matches("^(([0,1][0-9])|(2[0-3])):[0-5][0-9]$")) {
                    massage.setReceivingTime(massageFields[i]);
                    massage.setMassageContent(massageContent.toString());
                    massageList.add(massage);

                    if (i + 1 == massageFields.length) {
                        break;
                    }

                    massage = new Massage(massageFields[0], "", "");
                    massageContent = new StringBuilder();
                }else {
                    massageContent.append(massageFields[i]).append("\n");
                }
            }
        }

        return massageList;
    }
}
