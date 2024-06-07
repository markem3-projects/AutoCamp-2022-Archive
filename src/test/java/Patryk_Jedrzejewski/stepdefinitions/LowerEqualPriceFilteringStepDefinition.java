package Patryk_Jedrzejewski.stepdefinitions;

import Patryk_Jedrzejewski.pageObjects.MenuPage;
import Patryk_Jedrzejewski.pageObjects.RestaurantPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LowerEqualPriceFilteringStepDefinition {
    private final RestaurantPage restaurant = new RestaurantPage();
    private final MenuPage menuPage = new MenuPage();

    @Given("I am on the Restaurant website, I go to Menu and change resolution of screen at {int}x{int}")
    public void openMenuAndSetResolution(int height, int width){
        restaurant.open();
        menuPage.gotoMenu();
        restaurant.changeResolution(height, width);
    }
    @When("I expand filters and set price slider at {int} horizontally and {int} vertically")
    public void expandFiltersAndSetPriceSlider(int horizontal, int vertical){
        menuPage.movePriceSlider(horizontal,vertical);
    }
    @Then("{string} should be displayed")
    public void expectedItemShoudlBeDisplayed(String expectedItem){
        assertTrue(menuPage.item(expectedItem));
    }
}
