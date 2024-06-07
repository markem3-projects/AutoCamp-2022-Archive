package Mikołaj_Starzak.stepDefinitions;

import Mikołaj_Starzak.pageObjects.PageHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberBasketStepDefinition {
    private final PageHome page = new PageHome();
    @Given("I'm on a menu page")
    public void iMOnAMainPage() {
        page.openAndResizeWindow();
    }

    @When("I order first food item i see using my booking id {string}")
    public void iOrderFirstFoodItemISeeUsingMyBookingId(String bookingId) {
        page.menu();
        page.addFoodToOrder();
        page.completeOrder(bookingId);
    }

    @Then("I should get a confirmation message {string}")
    public void iShouldGetAConfirmationMessage(String confirm) {
        page.should(confirm);
    }
}
