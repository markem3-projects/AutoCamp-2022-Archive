package Elvira_Yukhnevich.stepdefinitions;

import Elvira_Yukhnevich.pageobjects.BookTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InviteStepDefinition {
    private final BookTablePage bookTablePage = new BookTablePage();
    @Given("I am on (.*?) website")
    public void i_open(){
        bookTablePage.open();
    }
    @When("I invite with date {string}, name {string}, email {string}, invitationEmail = {string}")
    public void i_invite(String date, String name, String email, String invitationEmail){
        bookTablePage.invite(date, name, email, invitationEmail);
    }
    @Then("I invited")
    public void i_invited(){
        bookTablePage.invited();
    }
}
