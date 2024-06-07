package Sebastian_Smoluch.tests;

import java.lang.*;
import java.net.MalformedURLException;
import java.net.URL;

import Sebastian_Smoluch.pages.BookTablePage;
import Sebastian_Smoluch.pages.HomePage;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class Tests {
    HomePage home = new HomePage();
    BookTablePage bookTable = new BookTablePage();
    public RemoteWebDriver driver;
    private final String driverLink = "http://localhost:4444/wd/hub";
    private final String seleniumGridUrl = "http://172.20.0.7";

    @BeforeEach
    public void init() throws MalformedURLException
    {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","firefox");
        driver = new RemoteWebDriver(new URL(driverLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        Selenide.open(seleniumGridUrl);
        sleep(1000);
    }

    @Test
    public void checkIfUserIsSuccessfullyRegistered(){
        //input
        String username = "test918s111523";
        String email = "test98172@gmail.com";
        String password = "1TreD67@!";
        String confirmPassword = "1TreD67@!";

        sleep(1000);
        home.clickRegisterAndLoginButton();
        sleep(1000);
        home.clickSignUpTabButton();
        sleep(1000);

        //register setting form data
        home.setRegisterUsernameValue(username);
        home.setRegisterEmailValue(email);
        home.setRegisterPasswordValue(password);
        home.setRegisterConfirmPasswordValue(confirmPassword);
        home.checkSignUpAcceptTermsCheckbox();

        home.clickSignUpSubmitButton();
        sleep(200);

        //registration check
        String expectedResult = username + " Register successful";
        assertEquals(expectedResult, home.getSnackBarText());
    }

    @Test
    public void checkIfLanguageRemainsUnchangedAfterRefresh(){
        String expectedResult = "Wiecej niz pyszne jedzenie";
        String expectedFinalResult = "More than just delicious food";

        //switching website's language
        home.clickDropDownLanguageList();
        home.switchLanguageToPolish();

        //check result before refresh
        assertEquals(expectedResult, home.getSubtitleText());

        //check result after refresh
        refresh();
        assertEquals(expectedFinalResult, home.getSubtitleText());
    }

    @Test
    public void checkIfSubmittingInvitationFriendRequestWorks() {
        //input
        String date = "7/29/2022, 10:32 AM";
        String name = "test98172";
        String email = "test98172@gmail.com";
        String guestInvitationEmail = "test@test.pl";

        bookTable.init();
        bookTable.clickInviteFriendsTabButton();

        //invite friends setting form data
        bookTable.setInvitationFriendDateValue(date);
        bookTable.setInvitationFriendNameValue(name);
        bookTable.setInvitationFriendEmailValue(email);
        bookTable.setInvitationFriendGuestInvitationEmailValue(guestInvitationEmail);
        bookTable.checkInviteFriendsAcceptTermsCheckbox();

        //invite friends button enabled check
        bookTable.checkIfInviteFriendsButtonIsEnabled();
    }

    @AfterEach
    public void close(){
        driver.quit();
    }
}