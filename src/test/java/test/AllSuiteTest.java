package test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

import test.language.LanguageTest;
import test.page.group.TestAddGroup;
import test.page.idea.TestAddNewEmotionToTheWall;
import test.page.login.TestLoginPage;
import test.page.message.TestSendMessageUser;
import test.page.message.TestSendParameterizedMessage;
import test.page.music.TestAddMusic;
import test.page.photo.TestAddPhoto;
import test.page.post.TestPost;

@Suite
@SelectClasses({TestPost.class, TestAddNewEmotionToTheWall.class, TestLoginPage.class, TestSendMessageUser.class,
        TestSendParameterizedMessage.class, TestAddMusic.class, TestAddPhoto.class, TestAddGroup.class, LanguageTest.class})
public class AllSuiteTest {
}
