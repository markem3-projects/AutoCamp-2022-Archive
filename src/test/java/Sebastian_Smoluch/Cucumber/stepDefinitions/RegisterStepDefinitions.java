package Sebastian_Smoluch.Cucumber.stepDefinitions;

import Sebastian_Smoluch.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class RegisterStepDefinitions {
    HomePage home = new HomePage();

    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        home.init();
    }
    @When("User registers with following data {string}, {string}, {string}, {string}")
    public void user_registers_with_following_data(String username, String email, String password, String confirmPassword) {
        home.clickRegisterAndLoginButton();
        home.clickSignUpTabButton();

        //register setting form data
        home.setRegisterUsernameValue(username);
        home.setRegisterEmailValue(email);
        home.setRegisterPasswordValue(password);
        home.setRegisterConfirmPasswordValue(confirmPassword);
        home.checkSignUpAcceptTermsCheckbox();

        home.clickSignUpSubmitButton();
        sleep(200);
    }
    @Then("User should be registered successfully as {string}")
    public void user_should_be_registered_successfully(String username) {
        String expectedResult = username + " Register successful";
        assertEquals(expectedResult, home.getSnackBarText());
    }
}
