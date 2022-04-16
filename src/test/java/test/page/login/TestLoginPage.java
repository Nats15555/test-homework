package test.page.login;

import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;

public class TestLoginPage extends AbstractTest {

   @Test
    public void authorization(){
       Assert.assertTrue(mainPage.isAuth(user));
    }

    @Test
    public void authorizationAndLogOutTest() {
        Assert.assertTrue(mainPage.logOut().intoLoginPage());
    }
}

