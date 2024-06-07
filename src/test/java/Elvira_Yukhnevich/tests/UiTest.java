package Elvira_Yukhnevich.tests;
import Elvira_Yukhnevich.pageobjects.*;

import static org.junit.jupiter.api.Assertions.*;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URL;

public class UiTest {
    private final RestaurantPage restaurant = new RestaurantPage();
    private final BookTablePage bookTablePage = new BookTablePage();
    private final MenuPage menuPage = new MenuPage();
    public RemoteWebDriver driver;
    private final String driverLink = "http://172.19.0.5:4444/wd/hub";

    @BeforeEach
    public void init() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","chrome");
        driver = new RemoteWebDriver(new URL(driverLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        restaurant.openLocal();
    }

    //login valid user: PASS
    @Test
    protected void loginPass(){
        String username = "user0",
                password = "password";
        restaurant.login(username,password);
        assertTrue(restaurant.logged(username));
    }

    //invite friends: FAIL
//    @Test
//    protected void invite(){
//        String date = "7/30/2022, 1:17 PM",
//                name = "Elvira",
//                email = "qwert@q.ru",
//                invitationEmail = "asdfg@we.ru";
//        bookTablePage.invite(date, name, email, invitationEmail);
//        bookTablePage.invited();
//    }

    //cannot change language in description of recipe from english to polish: PASS
    @Test
    protected void plLanguageFail(){
        String newLang = "Polski";
        menuPage.changeLanguage(newLang);
        assertTrue(menuPage.isEng());
    }

    @AfterEach
    public void after(){
        driver.quit();
    }
}
