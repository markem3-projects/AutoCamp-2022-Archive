package Elvira_Yukhnevich.stepdefinitions;

import Elvira_Yukhnevich.pageobjects.RestaurantPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinition {
    private final RestaurantPage restaurant = new RestaurantPage();
    @Given("I am on the Reastaurant website")
    public void i_am_on_the_Reastaurant_website(){
        restaurant.open();
    }
    @When("I am logging in as {string} with {string}")
    public void i_login(String username, String password){
        restaurant.login(username,password);
    }
    @Then("I should be logged in as {string}")
    public void i_logged_in(String username){
        assertTrue(restaurant.logged(username));
    }
}
