package Adrian_Szandala.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import java.time.Duration;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private static final String localURL = "http://mts-reverse-proxy ";
    private static final By loginButton = byText("person_outline");
    private static final By userNameField = byName("username");
    private static final By userPassField = byName("password");
    private static final By submitLoginButton = byName("submitLogin");

    public void openHomePage() {
        Selenide.open(localURL);
    }
    public void clickLogin() {
        $(loginButton).click();
    }
    public void enterLoginData(String userName, String userPass) {
        $(userNameField).setValue(userName);
        $(userPassField).setValue(userPass);
    }
    public void clickSubmitButton() {
        $(submitLoginButton).click();
    }
    public Boolean checkIfLogin(String userName) {
        return $(byText(userName)).should(Condition.visible, Duration.ofSeconds(10)).isDisplayed();
    }
}
