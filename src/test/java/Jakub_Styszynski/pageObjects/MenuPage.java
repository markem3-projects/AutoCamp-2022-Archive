package Jakub_Styszynski.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.google.common.collect.Iterables;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class MenuPage {

    private static final By selectorDishName = By.cssSelector("app-own-menu-card-details>div:nth-child(2)");
    private static final By selectorApplyFiltersButton = By.cssSelector(".filter-actions>:nth-child(2)");
    private static final By selectorAscDescOrderButton = By.cssSelector(".search>:nth-child(2)>:nth-child(1)>:nth-child(2)");

    private static final String baseUrl = "http://mts-reverse-proxy/";
    private static final String menuEndpoint = "menu";
    public RemoteWebDriver driver;
    private final String driverLink = "http://selenium-hub:4444/wd/hub";


    public void init() throws MalformedURLException {
        //ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","firefox");
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","chrome");
        driver = new RemoteWebDriver(new URL(driverLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        //Selenide.open(url) //przez adres url
        Selenide.open(baseUrl + menuEndpoint); //przez przeglądarkę
    }

    public void clean(){
        driver.quit();
    }

    public List<String> makeListOfAllDisplaydDishes() {
        ElementsCollection allDishes = $$(selectorDishName);
        List<String> listOfDishes = new ArrayList<String>();

        for (int i = 0; i < allDishes.size(); i++) {
            String text = Iterables.get(allDishes, i).getText();
            listOfDishes.add(text);
        }
        return listOfDishes;
    }

    public void clickApplyFiltersButton(){
        $(selectorApplyFiltersButton).click();
    }

    public void clickAscDescOrderButton(){
        $(selectorAscDescOrderButton).click();
    }

}
