package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.language.LanguageTest;
import test.page.group.TestAddGroup;
import test.page.login.TestLoginPage;
import test.page.message.TestSendMessageUser;
import test.page.message.TestSendParameterizedMessage;
import test.page.music.TestAddMusic;
import test.page.music.TestDeleteMusic;
import test.page.photo.TestAddPhoto;

@Suite
@SelectClasses({ TestLoginPage.class, TestSendMessageUser.class, TestSendParameterizedMessage.class
        , TestAddMusic.class, TestDeleteMusic.class, TestAddPhoto.class, TestAddGroup.class})
public class AllSuiteTest {
}
