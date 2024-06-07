package Mikołaj_Starzak.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PageHome {
    private static final By selectorSubmit = byName("orderSubmit");
    private static final By selectorCheckbox = byId("mat-checkbox-1");
    private static final By selectorBookingId = byName("orderBookingID");
    private static final By selectorAddOrder = byText("ADD TO ORDER");
    private static final By selectorOrder = byName("order");
    private static final String pageLink = "http://mts-devonfw-core.cloud.okteto.net/restaurant";
    private static final By selectorMenuView = byName("viewMenu");
    private static final String username = "user0";
    private static final String userPassword = "password";
    private static final By selectorLoginIcon = byName("login");
    private static final By selectorFindUsernameText = byName("username");
    private static final By selectorFindPasswordText = byName("password");
    public static final By selectorSubmitLoginData = byName("submitLogin");
    private static final String orderText = "123";
    private static final String successfulTestResult = "Order complete";
    private static final int height = 1280;
    private static final int width = 720;

    private void openSite() {
        Selenide.open(pageLink);
    }
    public PageHome login(){
        personOutline();
        wait100ms();
        username(username);
        password(userPassword);
        //submit(); //selenium nie lubi tej metody, w przeglądarce była konieczna ¯\_(ツ)_/¯
        return this;
    }
    public PageHome personOutline(){
        $(selectorLoginIcon).click();
        return this;
    }
    public PageHome username(String text) {
        $(selectorFindUsernameText).val(text).pressEnter();
        return this;
    }
    public PageHome password(String text) {
        $(selectorFindPasswordText).val(text).pressEnter();
        return this;
    }
    public PageHome submit(){
        wait100ms();
        $(selectorSubmitLoginData).click();
        return this;
    }
    public PageHome should(String text){
        $(byText(text)).should(Condition.exist);
        return this;
    }
    public PageHome shouldOrder(){
        should(successfulTestResult);
        return this;
    }
    public PageHome shouldUser(){
        wait100ms();
        should(username);
        return this;
    }
    public PageHome menu(){
        wait100ms();
        $(selectorOrder).click();
        $(selectorMenuView).click();
        return this;
    }
    public PageHome addFoodToOrder(){
        $(selectorAddOrder).click();
        return this;
    }
    public PageHome completeOrder(String text){
        bookOrder(text);
        checkboxOrder();
        wait100ms();
        submitOrder();
        return this;
    }
    private PageHome bookOrder(String text){
        $(selectorBookingId).setValue(text);
        return this;
    }
    private PageHome submitOrder(){
        $(selectorSubmit).click();
        wait100ms();
        return this;
    }
    private PageHome checkboxOrder(){
        $(selectorCheckbox).click();
        return this;
    }
    public PageHome completeOrderSample(){
        wait100ms();
        completeOrder(orderText);
        wait100ms();
        return this;
    }
    public void wait100ms(){
        sleep(100);
    }
    private void resolution(){
        getDriver().manage().window().setSize(new Dimension(height,width));
    }
    protected WebDriver getDriver(){
        WebDriver driver = WebDriverRunner.getWebDriver();
        return driver;
    }
    public void openAndResizeWindow(){
        openSite();
        resolution();
    }
}