package Patryk_Jedrzejewski.pageObjects;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class MenuPage extends RestaurantPage{

    private static final By selectorButtonFilters = byText("FILTERS");
    private static final By selectorButtonMenu = byText("MENU");
    private static final By selectorButtonApplyFilters = byText("Apply Filters");
    private static final By selectorSliderPrice = byAttribute("formcontrolname", "maxPrice");

    public boolean item(String expectedItem){
        return $(byText(expectedItem)).should(Condition.visible, Duration.ofMillis(2500)).isDisplayed();
    }

    public void gotoMenu() {
        $(selectorButtonMenu).should(Condition.visible, Duration.ofMillis(1000)).click();
    }

    public void movePriceSlider(int x, int y){
        WebElement PriceSlider = $(selectorSliderPrice);
        if(!PriceSlider.isDisplayed()){
            $(selectorButtonFilters).should(Condition.visible, Duration.ofMillis(5000)).click();
        }
        $(selectorSliderPrice).should(Condition.visible, Duration.ofMillis(5000)).isDisplayed();
        actions().dragAndDropBy(PriceSlider, x, y).perform();
        $(selectorButtonApplyFilters).should(Condition.visible, Duration.ofMillis(1000)).click();
    }
}
