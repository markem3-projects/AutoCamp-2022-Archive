package Mikołaj_Starzak.uTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Mikołaj_Starzak/CucumberLogin.feature", glue = "Mikołaj_Starzak.stepDefinitions")
public class CucumberLoginTest {
}

