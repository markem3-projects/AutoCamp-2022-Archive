package Jakub_Styszynski.Cucumber.stepDefinition;

import Jakub_Styszynski.pageObjects.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static com.codeborne.selenide.Selenide.sleep;

public class CheckLinkStepDefinitions {

    HomePage homePage = new HomePage();

    @When("User clicks devonfw link")
    public void user_clicks_devonfw_link() {
        homePage.clickDevonfwLink();
    }
    @Then("User should be navigated to {string}")
    public void user_should_be_navigated_to(String link) {
        String  actualURL = homePage.getActualValueOfDevonLink();
        Assertions.assertEquals(link, actualURL);
        homePage.clean();
    }
}
