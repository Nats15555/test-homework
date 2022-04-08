package page.massage;

import org.openqa.selenium.WebDriver;

public interface MassagePageInterface {

    MassagePageInterface openDialog(String identification);

    MassagePageInterface sendMassage(String massage);

    boolean chekMassage(String massage);

}
