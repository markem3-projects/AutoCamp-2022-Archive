package Patryk_Jedrzejewski.stepdefinitions;

import Patryk_Jedrzejewski.pageObjects.RestaurantPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinition {
    private final RestaurantPage restaurant = new RestaurantPage();

    @Given("I am on the Restaurant website")
    public void openWebsite() {
        restaurant.open();
    }

    @When("I am logging in as {string} with {string}")
    public void logiIn(String username, String password) {
        restaurant.login(username, password);
    }

    @Then("I should be logged in as {string}")
    public void checkUsername(String username) {
        assertTrue(restaurant.nickname(username));
    }
}
