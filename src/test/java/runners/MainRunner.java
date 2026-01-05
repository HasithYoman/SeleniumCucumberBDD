package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//Now the runner class knows where feature file stored and stepDefinitions stored
@CucumberOptions(features ={"classpath:features"}, glue = {"stepDefinitions"},
        tags = "@contact_us", monochrome = true, dryRun = false,
        plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json"})
public class MainRunner extends AbstractTestNGCucumberTests {
    //run scenarios in parallel
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
