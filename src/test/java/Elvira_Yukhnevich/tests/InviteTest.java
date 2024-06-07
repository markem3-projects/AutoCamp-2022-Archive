package Elvira_Yukhnevich.tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/Elvira_Yukhnevich/invite.feature", glue = "Elvira_Yukhnevich.stepdefinitions", plugin = {"pretty"})
public class InviteTest {
}
