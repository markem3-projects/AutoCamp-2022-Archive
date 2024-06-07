package Jakub_Styszynski.uiTests;

import Jakub_Styszynski.pageObjects.HomePage;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;


import static com.codeborne.selenide.Selenide.sleep;

public class HomePageTests {

    HomePage homePage = new HomePage();

    @BeforeEach
    public void setup() throws MalformedURLException {
        homePage.init();
    }

    @AfterEach
    public void cleanup(){
        homePage.clean();
    }

    @Test
    public void shouldBeTrueIfLinkNavigatesToCorrectPage(){
        //given
        String expectedURL = "http://devonfw.com/";
        //when

        //then
        String  actualURL = homePage.getActualValueOfDevonLink();
        Assertions.assertEquals(expectedURL, actualURL);
        sleep(200);
    }

    @Test
    public void shouldBeTrueIfUserCanSignInWithCorrectCredentials(){
        //given
        final String expectedUserName = "user0";
        final String inputUsername = "user0";
        final String inputPassword = "password";

        //when
        homePage.clickLoginButton();
        sleep(200);
        homePage.setLoginUsernameValue(inputUsername);
        homePage.setLoginPasswordValue(inputPassword);
        sleep(200);
        homePage.clickSubmitLoginButton();

        //then
        String name = homePage.getUsernameOfLoggedUser();
        Assertions.assertEquals(expectedUserName, name);
        sleep(200);
    }

}
