package Adrian_Szandala.Tests;


import Adrian_Szandala.Pages.HomePage;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.ImmutableCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class HomePageTest {
    private static final String userName = "u12s13!A";
    private static final String userPass = "u12s13!A";
    private HomePage homePage = new HomePage();
    public RemoteWebDriver driver;
    private final String driverURL = "http://selenium-hub:4444/wd/hub";

    @BeforeEach
    public void setUp() throws MalformedURLException {
        ImmutableCapabilities capabilities = new ImmutableCapabilities("browserName", "chrome");
        driver = new RemoteWebDriver(new URL(driverURL), capabilities);
        System.out.println(capabilities.getBrowserName());
        WebDriverRunner.setWebDriver(driver);
    }
    //user should be created before test
    @Test
    public void loginPositive() {
        homePage.openHomePage();
        homePage.clickLogin();
        homePage.enterLoginData(userName, userPass);
        homePage.clickSubmitButton();
        assertTrue(homePage.checkIfLogin(userName));
    }
    @AfterEach
    public void after(){
        driver.quit();
    }
}
