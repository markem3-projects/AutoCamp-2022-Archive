package Patryk_Jedrzejewski.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import java.time.Duration;


import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class RestaurantPage {

    protected static final String URL = "http://localhost:8081";
    protected static final String LOCALHOST = "http://mts-reverse-proxy";

    private static final By selectorButtonLogin = byName("login");
    private static final By selectorInputUsername = byName("username");
    private static final By selectorInputPassword = byName("password");
    private static final By selectorButtonSubmitLogin = byName("submitLogin");
    private static final By selectorButtonAccount = byName("account");
    private static final By selectorButtonChangePassword = byName("changePassword");
    private static final By selectorInputOldPassword = byName("oldPassword");
    private static final By selectorInputNewPassword = byName("newPassword");
    private static final By selectorInputVerifyPassword = byName("verifyPassword");
    private static final By selectorButtonChangePasswordSubmit = byName("changePasswordSubmit");
    private static final By selectorButtonLogout = byName("logout");

    public boolean nickname(String username){
            sleep(500);
            return $(byText(username)).isDisplayed();
    }

    public void open() {
        Selenide.open(URL);
    }

    public void openLocalhost() {
        Selenide.open(LOCALHOST);
    }

    public void login(String username, String password){
        $(selectorButtonLogin).should(Condition.visible, Duration.ofMillis(500)).click();
        $(selectorInputUsername).setValue(username);
        $(selectorInputPassword).setValue(password);
        $(selectorButtonSubmitLogin).should(Condition.visible, Duration.ofMillis(2500)).click();
    }

    public void changePassword(String oldPassword, String newPassword, String verifyPassword){
        $(selectorButtonAccount).click();
        $(selectorButtonChangePassword).click();
        $(selectorInputOldPassword).setValue(oldPassword);
        $(selectorInputNewPassword).setValue(newPassword);
        $(selectorInputVerifyPassword).setValue(verifyPassword);
        $(selectorButtonChangePasswordSubmit).click();
    }

    public void logout(){
        $(selectorButtonAccount).click();
        $(selectorButtonLogout).click();
    }

    protected WebDriver getDriver()
    {
        WebDriver driver = WebDriverRunner.getWebDriver();
        return driver;
    }

    public void changeResolution(int height, int width)
    {
        getDriver().manage().window().setSize(new Dimension(height,width));
    }
}
