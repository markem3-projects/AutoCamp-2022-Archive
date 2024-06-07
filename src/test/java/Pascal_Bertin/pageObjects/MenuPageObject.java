package Pascal_Bertin.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selectors.byTagName;
import static com.codeborne.selenide.Selenide.*;

public class MenuPageObject {
    private final static String siteUrl = "https://mts-devonfw-core.cloud.okteto.net/menu";
    private final static By filtersDropdownMenu = By.cssSelector("#mat-select-value-1");
    private final static By filterNameOption = By.cssSelector("#mat-option-2");
    private final static By sortingIcon = By.xpath("//*[text()[contains(.,'vertical_align_bottom')]]");
    private final static By applyFilters = By.xpath("//button[@type='submit']");
    private final static ElementsCollection allProducts = $$(byTagName("app-public-menu-card"));
    private final static SelenideElement firstProductTitle = allProducts.first().$("mat-card > app-own-menu-card-details > div > h3");

    public void init() {
        open(siteUrl);
    }

    public void clean(){
        WebDriverRunner.closeWebDriver();
    }

    public void clickOnFiltersDropdownMenu() {
        $(filtersDropdownMenu).click();
    }

    public void selectFilterNameOption() {
        $(filterNameOption).click();
    }

    public void changeSortingOrder() {
        $(sortingIcon).click();
    }

    public void clickToApplyFilters() {
        $(applyFilters).click();
    }

    public String getFirstProductTitle() {
        return firstProductTitle.getText();
    }
}
