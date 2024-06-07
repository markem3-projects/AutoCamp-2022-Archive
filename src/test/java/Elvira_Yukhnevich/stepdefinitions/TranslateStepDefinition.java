package Elvira_Yukhnevich.stepdefinitions;

import Elvira_Yukhnevich.pageobjects.MenuPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.*;

public class TranslateStepDefinition {
    public final MenuPage menuPage = new MenuPage();
    @Given("I am on the (.*?) website")
    public void i_open(){
        menuPage.open();
    }
    @When("I change language to {string}")
    public void i_change_language(String lang){
        menuPage.changeLanguage(lang);
    }
    @Then("The description on the website is not in English")
    public void i_changed_language(){
        assertFalse(menuPage.isEng());
    }
}
