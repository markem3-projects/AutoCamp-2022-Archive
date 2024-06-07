package Pascal_Bertin.pageObjects;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HomePageObject {
    private final static String siteUrl = "https://mts-devonfw-core.cloud.okteto.net";
    private final static By userLoginIcon = By.xpath("//button[@name='login']");
    private final static By registrationButton = By.cssSelector("#mat-tab-label-0-1");
    private final static By userNameInput = By.cssSelector("#mat-input-3");
    private final static By userLoginNameInput = By.cssSelector("#mat-input-1");
    private final static By userEmailInput = By.cssSelector("#mat-input-4");
    private final static By userPasswordInput = By.cssSelector("#mat-input-5");
    private final static By userLoginPasswordInput = By.cssSelector("#mat-input-2");
    private final static By userRepeatPasswordInput = By.cssSelector("#mat-input-6");
    private final static By acceptTermsCheckbox = By.cssSelector("#mat-checkbox-2");
    private final static By confirmRegistrationButton = By.xpath("//button[@name='registerSubmit']");
    private final static By confirmLoginButton = By.xpath("//button[@name='submitLogin']");
    private final static By confirmationMessage = By.cssSelector(".mat-simple-snack-bar-content");

    public void init(){
        open(siteUrl);
    }

    public void clean(){
        WebDriverRunner.closeWebDriver();
    }

    public void clickOnUserLoginIcon() {
        $(userLoginIcon).click();
    }

    public void clickOnRegistrationButton() {
        $(registrationButton).click();
    }

    public void setAllRegistrationFormInputs(
            String userNameData,
            String emailData,
            String passwordData)
    {
        $(userNameInput).setValue(userNameData);
        $(userEmailInput).setValue(emailData);
        $(userPasswordInput).setValue(passwordData);
        $(userRepeatPasswordInput).setValue(passwordData);
        $(acceptTermsCheckbox).click();
    }

    public void setAllLoginFormInputs(
            String userNameData,
            String passwordData)
    {
        $(userLoginNameInput).setValue(userNameData);
        $(userLoginPasswordInput).setValue(passwordData);
    }

    public void clickConfirmRegistrationButton() {
        $(confirmRegistrationButton).click();
    }

    public void clickConfirmLoginButton() {
        $(confirmLoginButton).click();
    }

    public String getConfirmationMessage(){
        return $(confirmationMessage).getText();
    }
}
