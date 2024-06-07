package Pascal_Bertin.tests;

import Pascal_Bertin.pageObjects.HomePageObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserRegistrationTest {
    HomePageObject homePageObject = new HomePageObject();
    private static final String userNameData = "pascalbertin";
    private static final String userEmailData = "paski@poczta.onet.eu";
    private static final String userPasswordData = "zaq1@WSX";
    private static final String confirmationMessageSufix = " Rejestracja udana";

    @BeforeEach
    public void openSite(){
        homePageObject.init();
    }

    @AfterEach
    public void closeWebDriver() {
        homePageObject.clean();
    }

    @Test
    public void userRegistrationTest() {
        homePageObject.clickOnUserLoginIcon();

        sleep(5000);

        homePageObject.clickOnRegistrationButton();
        homePageObject.setAllRegistrationFormInputs(userNameData, userEmailData, userPasswordData);
        homePageObject.clickConfirmRegistrationButton();

        String actualMessage = homePageObject.getConfirmationMessage();
        String expectedMessage = userNameData + confirmationMessageSufix;
        assertEquals(expectedMessage, actualMessage);
    }
}
