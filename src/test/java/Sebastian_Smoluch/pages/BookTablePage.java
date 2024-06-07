package Sebastian_Smoluch.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BookTablePage {
    private static final String BookTableAddress = "http://172.20.0.7/bookTable";
    private static final By SelectorInviteFriendsTabButton = By.cssSelector("div[id='mat-tab-label-0-1']");
    private static final By SelectorInvitationFriendDateLabel = By.cssSelector("[id='mat-input-5']");
    private static final By SelectorInvitationFriendNameLabel = By.cssSelector("[id='mat-input-6']");
    private static final By SelectorInvitationFriendEmailLabel = By.cssSelector("[id='mat-input-7']");
    private static final By SelectorInvitationFriendGuestInvitationEmailLabel = By.cssSelector("[id='mat-chip-list-input-0']");
    private static final By SelectorInviteFriendCheckTermsCheckbox = By.cssSelector("[id='mat-checkbox-3'");
    private static final By SelectorInviteFriendsButton = By.cssSelector("button[name=inviteFriendsSubmit]");

    public void init(){
        open(BookTableAddress);
        sleep(500);
    }

    public void clickInviteFriendsTabButton(){
        $(SelectorInviteFriendsTabButton).click();
        sleep(500);
    }

    public void setInvitationFriendDateValue(String value){
        $(SelectorInvitationFriendDateLabel).setValue(value);
    }

    public void setInvitationFriendNameValue(String value){
        $(SelectorInvitationFriendNameLabel).setValue(value);
    }

    public void setInvitationFriendEmailValue(String value){
        $(SelectorInvitationFriendEmailLabel).setValue(value);
    }

    public void setInvitationFriendGuestInvitationEmailValue(String value){
        $(SelectorInvitationFriendGuestInvitationEmailLabel).setValue(value);
    }

    public void checkInviteFriendsAcceptTermsCheckbox(){
        $(SelectorInviteFriendCheckTermsCheckbox).click();
    }

    public void checkIfInviteFriendsButtonIsEnabled(){
        $(SelectorInviteFriendsButton).shouldBe(disabled);
    }
}
