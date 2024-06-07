package Adrian_Szandala.Tests;

import Adrian_Szandala.Pages.BookTable;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;


public class BookTableTest {
    private static final String inputName = "Adrian";
    private static final String bookingDate = "8/14/2022, 12:12 PM";
    private static final String mail = "2@wp.pl";
    private String tableGuestsPositive;
    private String tableGuestsNegative;
    private BookTable bookTable = new BookTable();
    public RemoteWebDriver driver;
    private final String driverURL = "http://selenium-hub:4444/wd/hub";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
        driver = new RemoteWebDriver(new URL(driverURL), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
    }

    @Test
    public void bookTableNegative() {
        tableGuestsNegative = "3.5";
        bookTable.openBookTable();
        bookTable.setDataBookTable(bookingDate, inputName, mail, tableGuestsNegative);
        bookTable.clickAcceptTerms();
        bookTable.clickBookingButton();
        bookTable.clickSendButton();
        assertFalse(bookTable.checkIfBooked());
    }

    @Test
    public void bookTablePositive() {
        tableGuestsPositive = "3";
        bookTable.openBookTable();
        bookTable.setDataBookTable(bookingDate, inputName, mail, tableGuestsPositive);
        bookTable.clickAcceptTerms();
        bookTable.clickBookingButton();
        bookTable.clickSendButton();
        assertTrue(bookTable.checkIfBooked());
    }
    @AfterEach
    public void after(){
        driver.quit();
    }

}
