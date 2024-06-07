package Sebastian_Smoluch.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {
    private static final By SelectorSignUpAndLoginButton = By.cssSelector("button[name=login]>span>mat-icon");
    private static final By SelectorSignUpTabButton = By.cssSelector(".mat-tab-labels>div:nth-child(2)>div");
    private static final By SelectorSignUpUsernameLabel = By.cssSelector("[id='mat-input-3']");
    private static final By SelectorSignUpEmailLabel = By.cssSelector("[id='mat-input-4']");
    private static final By SelectorSignUpPasswordLabel = By.cssSelector("[id='mat-input-5']");
    private static final By SelectorSignUpConfirmPasswordLabel = By.cssSelector("[id='mat-input-6']");
    private static final By SelectorSignUpCheckTermsCheckbox = By.cssSelector("[id='mat-checkbox-2']");
    private static final By SelectorSignUpSubmitButton = By.cssSelector("button[name=registerSubmit]>:nth-child(1)");
    private static final By SelectorSnackBarText = By.cssSelector("[class=mat-simple-snack-bar-content]");
    private static final By SelectorDropDownLanguageList = By.cssSelector("button[name=language]>span>span");
    private static final By SelectorClickPolishFlagButton = By.cssSelector("div[class=cdk-overlay-container]>:nth-child(2)>div>div>div>:nth-child(8)");
    private static final By SelectorSubtitleText = By.cssSelector("div[class='home-header']>span[class='subtitle']");

    public String getSnackBarText()
    {
        return $(SelectorSnackBarText).getText();
    }

    public void clickRegisterAndLoginButton(){
        $(SelectorSignUpAndLoginButton).click();
        sleep(500);
    }

    public void clickSignUpTabButton(){
        $(SelectorSignUpTabButton).click();
        sleep(500);
    }

    public void clickSignUpSubmitButton(){
        $(SelectorSignUpSubmitButton).click();
    }

    public void setRegisterUsernameValue(String value){
        $(SelectorSignUpUsernameLabel).setValue(value);
    }

    public void setRegisterEmailValue(String value){
        $(SelectorSignUpEmailLabel).setValue(value);
    }

    public void setRegisterPasswordValue(String value){
        $(SelectorSignUpPasswordLabel).setValue(value);
    }

    public void setRegisterConfirmPasswordValue(String value) {
        $(SelectorSignUpConfirmPasswordLabel).setValue(value);
    }

    public void checkSignUpAcceptTermsCheckbox(){
        $(SelectorSignUpCheckTermsCheckbox).click();
    }

    public void clickDropDownLanguageList() {
        $(SelectorDropDownLanguageList).click();
    }

    public void switchLanguageToPolish() {
        $(SelectorClickPolishFlagButton).click();
        sleep(200);
    }

    public String getSubtitleText(){
        return $(SelectorSubtitleText).getText();
    }
}
