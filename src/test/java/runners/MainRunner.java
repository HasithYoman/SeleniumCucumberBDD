package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//Now the runner class knows where feature file stored and stepDefinitions stored
@CucumberOptions(features ={"classpath:features"}, glue = {"stepDefinitions"},
        tags = "@Login", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
}
