import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPageObject extends AbstractTest{

   @Test
    public void authorization(){
        assertTrue(mainPage.authMainPage(user));
    }

    @Test
    public void authorizationAndLogOutTest() {
        assertTrue(mainPage.logOut().intoLoginPage());
    }
}

