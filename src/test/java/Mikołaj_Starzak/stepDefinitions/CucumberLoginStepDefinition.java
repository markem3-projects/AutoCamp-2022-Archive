package Mikołaj_Starzak.stepDefinitions;

import Mikołaj_Starzak.pageObjects.PageHome;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CucumberLoginStepDefinition {
    private final PageHome page = new PageHome();
    @Given("I have a username, password and a login page open")
    public void iHaveAUsernamePasswordAndALoginPageOpen() {
        page.openAndResizeWindow();
    }

    @When("I write my username {string} and password {string} in login page and then confirm")
    public void iWriteMyUsernameAndPasswordInLoginPageAndThenConfirm(String username, String userPassword) {
        page.personOutline();
        page.wait100ms();
        page.username(username);
        page.password(userPassword);
        page.submit();
    }

    @Then("I should be logged in as {string}")
    public void iShouldBeLoggedInAs(String username) {
        page.wait100ms();
        page.should(username);
    }
}
