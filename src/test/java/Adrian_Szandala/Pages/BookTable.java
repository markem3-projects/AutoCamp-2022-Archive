package Adrian_Szandala.Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;


import java.time.Duration;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class BookTable {
    private static final String localURL = "http://mts-reverse-proxy";
    private static final By succesBookedText = byText("Table succesfully booked");
    private static final By bookTableButton = byText("BOOK TABLE");
    private static final By dateField = byId("mat-input-1");
    private static final By nameField = byId("mat-input-2");
    private static final By mailField = byId("mat-input-3");
    private static final By tableGuestsField = byId("mat-input-4");
    private static final By checkBoxAcceptTerms = byId("mat-checkbox-2");
    private static final By bookingButton = byText("Book Table");
    private static final By sendButton = byName("bookTableConfirm");
    
    public void openBookTable() {
        Selenide.open(localURL);
        $(bookTableButton).click();

    }
    public void setDataBookTable(String bookingDate, String userName, String mail, String tableGuests) {
        $(dateField).setValue(bookingDate);
        $(nameField).setValue(userName);
        $(mailField).setValue(mail);
        $(tableGuestsField).setValue(tableGuests);
    }
    public void clickAcceptTerms() {
        $(checkBoxAcceptTerms).click();
    }
    public void clickBookingButton() {
        $(bookingButton).click();
    }
    public void clickSendButton() {
        $(sendButton).should(Condition.enabled, Duration.ofSeconds(5)).click();
    }
    public boolean checkIfBooked() {
        return $(succesBookedText).should(Condition.visible, Duration.ofSeconds(5)).isDisplayed();
    }

}
