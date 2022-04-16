package test.page.photo;

import java.io.File;
import java.nio.file.Path;

import org.junit.Assert;
import org.junit.Test;

import test.AbstractTest;

public class TestAddPhoto extends AbstractTest {

    private final Path photoAvatarPath = new File("src/main/resources/avatar.png").getAbsoluteFile().toPath();

    @Test
    public void addNewPhoto() {
        Assert.assertTrue( mainPage.openPhotoPage()
                .addNewPhoto(photoAvatarPath.toString())
                .checkAddingPhoto());
    }
}
