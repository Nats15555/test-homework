package test.page.user;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import generator.user.data.Name;
import generator.user.data.Surname;
import page.settings.SettingsPage;
import test.AbstractTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestNameChange extends AbstractTest {
    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
    private final String randomName = new Name().random();
    private final String randomSurname = new Surname().random();

    @BeforeEach
    public void login() {
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на смену имени и фамилии")
    @Test
    public void changeNameAndSurname() {
        SettingsPage settingsPage = mainPage.clickSettingsPage()
                .openChangePersonalData()
                .changeNameAndSurname(randomName, randomSurname)
                .refresh();
        assertTrue(settingsPage.checkChangePersonalData(randomName, randomSurname));
        settingsPage.clickImgOK().clickSettingsPage()
                .openChangePersonalData()
                .changeNameAndSurname(user.getNameAndSurname().split(" ")[0]
                        , user.getNameAndSurname().split(" ")[1])
                .refresh();
        assertTrue(settingsPage.checkChangePersonalData(user.getNameAndSurname().split(" ")[0]
                , user.getNameAndSurname().split(" ")[1]));
    }
}
