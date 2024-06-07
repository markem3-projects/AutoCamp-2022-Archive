package Elvira_Yukhnevich.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.selector.ByText;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class BookTablePage extends RestaurantPage{
    private static final By selectorBtnBookTable = byText("BOOK TABLE");
    private static final By selectorBtnInviteFriends = byText("Invite friends");
    private static final By selectorBtnInviteFriendsSubmit = By.name("inviteFriendsSubmit");
    private static final By selectorCheckboxAcceptTerms = byText("Accept terms");
    private static final By selectorInputBookingDate = byAttribute("formcontrolname", "bookingDate");
    private static final By selectorInputName= byAttribute("formcontrolname", "name");
    private static final By selectorInputEmail = byAttribute("formcontrolname", "email");
    private static final By selectorInputInvitationEmail = byAttribute("placeholder", "Enter invitation email");

    public void invite(String date, String name, String email, String invitationEmail){
        $(selectorBtnBookTable).click();
        $(selectorBtnInviteFriends).click();
        $(selectorInputBookingDate).should(Condition.visible, Duration.ofMillis(2000)).setValue(date);
        $(selectorInputName).setValue(name);
        $(selectorInputEmail).setValue(email);
        $(selectorInputInvitationEmail).setValue(invitationEmail);
        $(selectorCheckboxAcceptTerms).click();
    }
    public void invited() {
        $(selectorBtnInviteFriendsSubmit).shouldHave(Condition.attribute("disabled", "false"));
    }
}