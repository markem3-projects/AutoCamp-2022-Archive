package Adrian_Szandala.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"}, features = "classpath:Adrian_Szandala/login.feature", glue = "Adrian_Szandala.stepDefinitions")
public class LoginTestRunner {
}




