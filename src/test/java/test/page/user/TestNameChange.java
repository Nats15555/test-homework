package test.page.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import generator.user.data.Name;
import generator.user.data.Surname;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNameChange extends AbstractTest {
    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
    private final String reName = "technopolisBot1";
    private final String reSurname = "technopolisBot1";
    private final String randomName = new Name().random();
    private final String randomSurname = new Surname().random();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на смену имени и фамилии")
    @Test
    public void addNewPost() {
        mainPage.openUserPage()
                .clickSettingsPage()
                .openChangePersonalData()
                .changeNameAndSurname(randomName, randomSurname);
        //assertTrue();
    }
}
