package Adrian_Szandala.stepDefinitions;

import Adrian_Szandala.Pages.BookTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class BookTableStepDefinition {
    private final BookTable bookTable = new BookTable();

    @Given("User open book table page")
    public void user_open_book_table_page() {
        bookTable.openBookTable();
    }

    @When("User enters date {string}, name {string},email {string}, table guests {string}")
    public void user_enters_date_name_email_table_guests(String bookingDate, String inputName, String mail, String tableGuests) {
        bookTable.setDataBookTable(bookingDate, inputName, mail, tableGuests);
    }

    @When("Click on Accept terms")
    public void click_on_accept_terms() {
        bookTable.clickAcceptTerms();
    }

    @When("Click on BOOK TABLE")
    public void click_on_book_table() {
        bookTable.clickBookingButton();
    }

    @When("Click SEND button")
    public void click_send_button() {
        bookTable.clickSendButton();
    }

    @Then("Table should be succesfully booked")
    public void table_should_be_succesfully_booked() {
        assertFalse(bookTable.checkIfBooked());
    }
}
