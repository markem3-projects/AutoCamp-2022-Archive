package Sebastian_Smoluch.Cucumber.stepDefinitions;

import Sebastian_Smoluch.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LanguageCheckStepDefinitions {
    HomePage home = new HomePage();

    @When("User changes language to Polish")
    public void user_changes_language_to_polish() {
        home.clickDropDownLanguageList();
        home.switchLanguageToPolish();
    }
    @Then("Subtitle should contain {string}")
    public void subtitle_should_contain(String expectedResult) {
        assertEquals(expectedResult, home.getSubtitleText());
    }
    @When("User refreshes the website")
    public void user_refreshes_the_website() {
        refresh();
    }
}
