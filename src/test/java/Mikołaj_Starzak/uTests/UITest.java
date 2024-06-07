package Mikołaj_Starzak.uTests;

import Mikołaj_Starzak.pageObjects.PageHome;
import Mikołaj_Starzak.pageObjects.PageMenu;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class UITest {
    public RemoteWebDriver driver;
    private final String driverLink = "http://selenium-hub:4444/wd/hub";
    //ip selenium hub

    @BeforeEach
    public void init() throws MalformedURLException {
        //ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","firefox");
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","chrome");
        driver = new RemoteWebDriver(new URL(driverLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        //Selenide.open(url) //przez adres url
        Selenide.open("http://mts-reverse-proxy"); //przez przeglądarkę
        //ip reverse proxy
    }

    @AfterEach
    public void after(){
        driver.quit();
    }
    private final PageHome home = new PageHome();
    private final PageMenu menu = new PageMenu();
    private final PageHome homer = new PageHome();
    //login - passed
    @Test
    public void MTSLogin() {
        home.wait100ms();
        home.openAndResizeWindow();
        home.login();
        home.shouldUser();
    }
    
    @Test
    //search for certain food - failed
    public void MTSFilters() {
        menu.wait100ms();
        menu.openSiteMenu();
        menu.searchFoodNameCurry();
        menu.searchShouldFoodNameCurry();
    }
    //add to cart and order - failed
    @Test
    public void MTSBasket() {
        homer.wait100ms();
        homer.openAndResizeWindow();
        homer.menu();
        homer.addFoodToOrder();
        homer.completeOrderSample();
        homer.shouldOrder();
    }
    
}
