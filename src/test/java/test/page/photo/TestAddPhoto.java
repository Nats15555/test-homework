package test.page.photo;

import java.io.File;
import java.nio.file.Path;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import data.login.User;
import test.AbstractTest;

public class TestAddPhoto extends AbstractTest {

    protected final User user = new User.UserBuilder()
            .withLogin("technopolisBot145")
            .withPassword("technopolis16")
            .withNameAndSurname("technopolisBot1 technopolisBot1")
            .build();
    private final Path photoAvatarPath = new File("src/main/resources/avatar.png").getAbsoluteFile().toPath();

    @BeforeEach
    public void login(){
        mainPage = loginPage.doLogin(user);
    }

    @DisplayName("Тест на добавления фото к себе")
    @Test
    public void addNewPhoto() {
        assertTrue(mainPage.openPhotoPage()
                .addNewPhoto(photoAvatarPath.toString())
                .checkAddingPhoto());
    }
}
