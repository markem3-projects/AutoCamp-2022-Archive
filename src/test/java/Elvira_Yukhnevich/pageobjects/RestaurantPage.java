package Elvira_Yukhnevich.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RestaurantPage {
    private static final By selectorInputUsername = By.name("username");
    private static final By selectorInputPassword = By.name("password");
    private static final By selectorBtnSubmitLogin = By.name("submitLogin");
    private static final By selectorBtnLogin = byText("person_outline");
    private static final String link = "https://mts-devonfw-core.cloud.okteto.net/menu";
    private static final String linkLocal = "http://172.19.0.2";

    public void open() {
        Selenide.open(link);
    }
    
    public void openLocal() {
        Selenide.open(linkLocal);

    }
    
    public void login(String username, String password){
        $(selectorBtnLogin).click();
        $(selectorInputUsername).setValue(username);
        $(selectorInputPassword).setValue(password);
        $(selectorBtnSubmitLogin).click();
        sleep(6000);
    }

    public boolean logged(String username){
        return $(byText(username)).isDisplayed();
    }
}
