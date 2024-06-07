package Mikołaj_Starzak.stepDefinitions;

import Mikołaj_Starzak.pageObjects.PageMenu;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberFiltersStepDefinition {
    private final PageMenu page = new PageMenu();
    @Given("I have a food name and restaurant page")
    public void iHaveAFoodNameAndRestaurantPage() {
        page.openSiteMenu();
    }

    @When("I type in {string} in browser")
    public void iTypeInInBrowser(String foodName) {
        page.searchFoodAndApplyFilters(foodName);
    }

    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String foodName) {
        page.should(foodName);
    }
}
