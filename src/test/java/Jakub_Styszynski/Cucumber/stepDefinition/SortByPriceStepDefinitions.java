package Jakub_Styszynski.Cucumber.stepDefinition;

import Jakub_Styszynski.pageObjects.MenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;

public class SortByPriceStepDefinitions {
    MenuPage menuPage = new MenuPage();
    List<String> namesBefore;
    List<String> namesAfter;

    @Given("User is on menu page")
    public void user_is_on_menu_page() throws MalformedURLException {
        menuPage.init();
        sleep(200);
        namesBefore = menuPage.makeListOfAllDisplaydDishes();
        sleep(200);
    }
    @When("User sorts dishes ascending")
    public void user_sorts_dishes_ascending() {
        menuPage.clickAscDescOrderButton();
        sleep(200);
        menuPage.clickApplyFiltersButton();
        sleep(200);
    }
    @Then("Dishes should be displayed in correct order")
    public void dishes_should_be_displayed_in_correct_order() {
        namesAfter = menuPage.makeListOfAllDisplaydDishes();
        sleep(200);
        Collections.reverse(namesAfter);
        Assertions.assertEquals(namesBefore, namesAfter);
        menuPage.clean();
    }
}
