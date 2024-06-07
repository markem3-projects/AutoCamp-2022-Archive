package Pascal_Bertin.tests;

import Pascal_Bertin.pageObjects.HomePageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserSignInTest {
    HomePageObject homePageObject = new HomePageObject();
    private static final String userNameData = "pascalbertin";
    private static final String userPasswordData = "zaq1@WSX";
    private static final String expectedMessage = "Jestes zalogowany";

    @BeforeEach
    public void openSite() {
        homePageObject.init();
    }

    @AfterEach
    public void closeWebDriver() {
        homePageObject.clean();
    }

    @Test
    public void userSuccessfullySignInTest() {
        homePageObject.clickOnUserLoginIcon();
        homePageObject.setAllLoginFormInputs(userNameData, userPasswordData);
        homePageObject.clickConfirmLoginButton();

        String actualMessage = homePageObject.getConfirmationMessage();
        assertEquals(expectedMessage, actualMessage);
    }
}
