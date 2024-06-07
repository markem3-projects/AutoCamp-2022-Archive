package Jakub_Styszynski.Cucumber.stepDefinition;

import Jakub_Styszynski.pageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.net.MalformedURLException;
import static com.codeborne.selenide.Selenide.sleep;

public class LoginStepDefinitons {

    HomePage homePage = new HomePage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() throws MalformedURLException {
        homePage.init();
    }
    @When("User sign in as {string} with password {string}")
    public void user_sign_in_as_with_password(String login, String password) {
        homePage.clickLoginButton();
        sleep(200);
        homePage.setLoginUsernameValue(login);
        homePage.setLoginPasswordValue(password);
        sleep(200);
        homePage.clickSubmitLoginButton();
    }
    @Then("User should be logged in as {string}")
    public void user_should_be_logged_in_as(String username) {
        String name = homePage.getUsernameOfLoggedUser();
        Assertions.assertEquals(username, name);
        homePage.clean();
    }
}
