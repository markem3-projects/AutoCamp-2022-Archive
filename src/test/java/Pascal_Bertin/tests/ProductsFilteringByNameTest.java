package Pascal_Bertin.tests;

import Pascal_Bertin.pageObjects.MenuPageObject;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductsFilteringByNameTest {
    MenuPageObject menuPageObject = new MenuPageObject();
    private static final String expectedMessage = "BEER";

    @BeforeEach
    public void openSite() {
        menuPageObject.init();
    }

    @AfterEach
    public void closeWebDriver() {
        menuPageObject.clean();
    }

    @Test
    public void productsFilteringByNameTest() {
        menuPageObject.clickOnFiltersDropdownMenu();

        sleep(200);

        menuPageObject.selectFilterNameOption();
        menuPageObject.changeSortingOrder();
        menuPageObject.clickToApplyFilters();

        sleep(3000);

        String actualMessage = menuPageObject.getFirstProductTitle();
        assertEquals(expectedMessage, actualMessage);
    }
}
