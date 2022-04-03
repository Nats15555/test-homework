import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestSendMassage extends AbstractTest{
    @Test
    public void sendMassage() {
        String massage = "My test16";
        boolean chek = mainPage.openMassagePage()
                .openDialog("-82680697280182")
                .sendMassage(massage)
                .chekMassage(massage);
        System.out.println(chek);
       assertTrue(chek);//разобраться с тестом
    }
}
