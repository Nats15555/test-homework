package test.page;

import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;

public class TestPageObject extends AbstractTest {

   @Test
    public void authorization(){
       Assert.assertTrue(mainPage.isAuth(user));
       driver.close();
    }

    @Test
    public void authorizationAndLogOutTest() {
        Assert.assertTrue(mainPage.logOut().intoLoginPage());
        driver.close();
    }
}

