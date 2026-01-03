package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static driver.drivers.DriverFactory.cleanupDriver;
import static driver.drivers.DriverFactory.getDriver;


public class Hooks {
    public WebDriver driver;

    //in here- before test get executed opening chrome
    @Before
    public void setup(){
        getDriver();
    }
    //After test finishg close the chrome browser
    @After
    public void tearDown(){
        cleanupDriver();
    }
}
