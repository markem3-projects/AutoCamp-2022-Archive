package Patryk_Jedrzejewski.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
        features = "classpath:features/Patryk_Jedrzejewski/login.feature",
        glue = "Patryk_Jedrzejewski.stepdefinitions")
public class LoginTest {
}
