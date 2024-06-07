package Mikołaj_Starzak.pageObjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PageMenu {
    public static final String foodNameCurry = "THAI GREEN CHICKEN CURRY";
    private static final By selectorFoodNameCurry = byText(foodNameCurry);
    private static final By selectorApplyFiltersName = byText("Apply Filters");
    private static final By selectorFindTextBoxSearch =byId("mat-input-1");
    private static final String openMenuPage = "http://mts-devonfw-core.cloud.okteto.net/menu";
    public void openSiteMenu() {
        Selenide.open(openMenuPage);
    }
    public PageMenu searchFoodAndApplyFilters(String text) {
        $(selectorFindTextBoxSearch).val(text);
        wait1s();
        $(selectorApplyFiltersName).click();
        return this;
    }
    public PageMenu searchShouldFoodNameCurry(){
        should(foodNameCurry);
        return this;
    }
    public PageMenu searchFoodNameCurry(){
        searchFoodAndApplyFilters(foodNameCurry);
        return this;
    }
    public PageMenu should(String text){
        $(byText(text)).should(Condition.exist);
        return this;
    }
    public void wait100ms(){
        sleep(100);
    }
    private void wait1s(){
        sleep(1000);
    }
}
