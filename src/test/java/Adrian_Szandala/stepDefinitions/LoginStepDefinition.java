package Adrian_Szandala.stepDefinitions;

import Adrian_Szandala.Pages.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStepDefinition {
    private final HomePage homePage = new HomePage();

    @Given("User open login page")
    public void user_open_login_page() {
        homePage.openHomePage();
        homePage.clickLogin();
    }

    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String userName, String userPass) {
        homePage.enterLoginData(userName, userPass);
    }

    @When("Click on login button")
    public void clicks_on_login_button() {
        homePage.clickSubmitButton();
    }

    @Then("User should be login as {string}")
    public void user_should_be_login_as(String userName) {
        assertTrue(homePage.checkIfLogin(userName));
    }
}
