package Jakub_Styszynski.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePage {

    private static final By selectorLoginButton = By.cssSelector("[name=login]");
    private static final By selectorSubmitLoginButton = By.cssSelector("[name=submitLogin]");
    private static final By selectorLoginUsernameField = By.cssSelector("[name=username]");
    private static final By selectorLoginPasswordField = By.cssSelector("[name=password]");
    private static final By selectorUsernameOfLoggedUser = By.cssSelector("[data-name=userNameLogged]");
    private static final By selectorDevonLink = By.cssSelector(".title>span:nth-child(2)>a");
    private static final String baseUrl = "http://mts-reverse-proxy/";
    private static final String restaurantEndpoint = "restaurant";
    public RemoteWebDriver driver;
    private final String driverLink = "http://selenium-hub:4444/wd/hub";

    public void init() throws MalformedURLException {
        //ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","firefox");
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName","chrome");
        driver = new RemoteWebDriver(new URL(driverLink), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
        //Selenide.open(url) //przez adres url
        Selenide.open(baseUrl + restaurantEndpoint); //przez przeglądarkę
    }

    public void clean(){
        driver.quit();
    }

    public void clickLoginButton(){
        $(selectorLoginButton).click();
    }

    public void clickSubmitLoginButton(){
        $(selectorSubmitLoginButton).click();
    }

    public void setLoginUsernameValue(String username){
        $(selectorLoginUsernameField).setValue(username);
    }

    public void setLoginPasswordValue(String password){
        $(selectorLoginPasswordField).setValue(password);
    }

    public String getUsernameOfLoggedUser(){
        return $(selectorUsernameOfLoggedUser).getText();
    }

    public String getActualValueOfDevonLink(){
        return $(selectorDevonLink).getAttribute("href");
    }

    public void clickDevonfwLink(){
        $(selectorDevonLink).click();
    }
}
