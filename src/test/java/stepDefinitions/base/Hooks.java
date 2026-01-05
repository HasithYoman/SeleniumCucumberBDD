package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.sql.Timestamp;

import static driver.drivers.DriverFactory.cleanupDriver;
import static driver.drivers.DriverFactory.getDriver;


public class Hooks {
    public WebDriver driver;

    //in here- before test get executed opening chrome
    @Before
    public void setup(){
        getDriver();
    }

    @AfterStep
    public void captureExeptionImage(Scenario scenario) {
        // take screen shot if a scenario fail
//        if(scenario.isFailed()){
//            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//            String timemilliseconds = long.toString(timestamp.getTime());
//
//            byte[] screeshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
//            scenario.attach(screeshot, "image/png", timemilliseconds);
//        }
        if (scenario.isFailed()) {
            String timemilliseconds = String.valueOf(System.currentTimeMillis());

            byte[] screenshot = ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", timemilliseconds);
        }
    }

    //After test finishg close the chrome browser
    @After
    public void tearDown(){
        cleanupDriver();
    }
}
