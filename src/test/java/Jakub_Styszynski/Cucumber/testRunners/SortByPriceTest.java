package Jakub_Styszynski.Cucumber.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Jakub_Styszynski/SortByPrice.feature"
        ,glue = {"Jakub_Styszynski.Cucumber.stepDefinition"}
)
public class SortByPriceTest {
}
