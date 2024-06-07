package Sebastian_Smoluch.Cucumber.testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features/Sebastian_Smoluch/languageCheck.feature",
        glue = {"Sebastian_Smoluch.Cucumber.stepDefinitions"},
        plugin = {"pretty"}
)
public class LanguageCheckTest {

}
