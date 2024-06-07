package Patryk_Jedrzejewski.stepdefinitions;

import Patryk_Jedrzejewski.pageObjects.RestaurantPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ChangingPasswordStepDefinition {
    private final RestaurantPage restaurant = new RestaurantPage();
    @Given("I am on the Restaurant website and I am logging in as {string} with {string}")
    public void iae(String username, String password){
        restaurant.open();
        restaurant.login(username,password);
        assertTrue(restaurant.nickname(username));
    }
    @When("I am changing password from {string} to {string} and I am logging out")
    public void iw(String oldPassword, String newPassword){
        restaurant.changePassword(oldPassword,newPassword,newPassword);
        restaurant.logout();
    }
    @Then("I should log in using new password: {string} and I should be logged in as {string}")
    public void idsn(String newPassword, String username){
        restaurant.login(username,newPassword);
        assertTrue(restaurant.nickname(username));
    }
}
