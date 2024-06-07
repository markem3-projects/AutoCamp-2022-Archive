package Mikołaj_Starzak.uTests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:Mikołaj_Starzak/CucumberBasket.feature", glue = "Mikołaj_Starzak.stepDefinitions")
public class CucumberBasketTest {
}

