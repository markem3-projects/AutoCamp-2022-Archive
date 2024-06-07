package Sebastian_Smoluch.Cucumber.stepDefinitions;

import Sebastian_Smoluch.pages.BookTablePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InviteFriendsStepDefinitions {
    BookTablePage bookTable = new BookTablePage();
    @Given("User is on book table page, invite friends tab")
    public void user_is_on_book_table_page_invite_friends_tab() {
        bookTable.init();
        bookTable.clickInviteFriendsTabButton();
    }
    @When("User fills form with following data {string}, {string}, {string}, {string}")
    public void user_fills_form_with_following_data(String date, String name, String email, String guestInvitationEmail) {
        bookTable.setInvitationFriendDateValue(date);
        bookTable.setInvitationFriendNameValue(name);
        bookTable.setInvitationFriendEmailValue(email);
        bookTable.setInvitationFriendGuestInvitationEmailValue(guestInvitationEmail);
        bookTable.checkInviteFriendsAcceptTermsCheckbox();
    }
    @Then("User should be able to click Invite Friends button")
    public void user_should_be_able_to_click_invite_friends_button() {
        bookTable.checkIfInviteFriendsButtonIsEnabled();
    }
}
