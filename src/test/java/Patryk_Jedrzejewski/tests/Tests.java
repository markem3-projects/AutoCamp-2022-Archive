package Patryk_Jedrzejewski.tests;

import Patryk_Jedrzejewski.pageObjects.MenuPage;
import Patryk_Jedrzejewski.pageObjects.RestaurantPage;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class Tests {
    private final MenuPage menuPage = new MenuPage();
    private final RestaurantPage restaurant = new RestaurantPage();
    public RemoteWebDriver driver;
    private final String seleniumGridLink = "http://selenium-hub:4444/wd/hub";
    private final String seleniumGridLocalHostLink = "http://localhost:4444/wd/hub";

    @BeforeEach
    public void init() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","firefox");
        driver = new RemoteWebDriver(new URL(seleniumGridLocalHostLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        restaurant.openLocalhost();
    }

    @Test //passed for HORIZONTAL -225, failed for -275
    public void lowerEqualPriceFiltering(){
        final String EXPECTEDITEM = "TEA";
        final int HEIGHT = 1368;
        final int WIDTH = 770;
        final int HORIZONTAL = -225;
        final int VERTICAL = 0;
        menuPage.gotoMenu();
        restaurant.changeResolution(HEIGHT, WIDTH);
        menuPage.movePriceSlider(HORIZONTAL,VERTICAL);
        assertTrue(menuPage.item(EXPECTEDITEM));
    }

    @Test //passed
    public void loggingIn(){
        final String USERNAME = "user0";
        final String PASSWORD = "password";
        restaurant.login(USERNAME,PASSWORD);
        assertTrue(restaurant.nickname(USERNAME));
    }

    @Test //failed for assertTrue, passed for assertFalse
    public void changingPassword(){
        final String USERNAME = "user0";
        final String PASSWORD = "password";
        final String NEWPASSWORD = "123";
        restaurant.login(USERNAME,PASSWORD);
        restaurant.changePassword(PASSWORD,NEWPASSWORD,NEWPASSWORD);
        restaurant.logout();
        restaurant.login(USERNAME,NEWPASSWORD);
        assertFalse(restaurant.nickname(USERNAME));
    }

    @AfterEach
    public void after(){
        driver.quit();
    }
}
