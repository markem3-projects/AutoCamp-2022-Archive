package Elvira_Yukhnevich.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MenuPage extends RestaurantPage{
    private static final By selectorBtnLanguage = By.name("language");
    private static final By selectorBtnMENU = byText("MENU");
    private static final By selectorLabelDescription = byText("Master this aromatic, creamy & extremely tasty chicken Thai green curry recipe from Jamie Oliver & treat yourself to an authentic taste of South East Asia.");
    public void changeLanguage(String lang){
        $(selectorBtnLanguage).click();
        $(byText(lang)).should(Condition.visible, Duration.ofMillis(500)).click();
    }

    public boolean isEng() {
        $(selectorBtnMENU).click();
        return $(selectorLabelDescription).should(Condition.visible, Duration.ofMillis(7000)).isDisplayed();
    }
}
