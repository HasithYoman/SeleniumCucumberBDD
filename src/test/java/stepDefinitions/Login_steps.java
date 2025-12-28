package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Login_steps {
    private WebDriver driver;

    //in here- before test get executed opening chrome
    @Before("@Login")
    public void setup(){

        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
        System.setProperty(
                "webdriver.chrome.driver",
                System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe"
        );
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    //After test finishg close the chrome browser
    @After("@Login")
    public void tearDown(){
        driver.quit();
    }
    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page() {
    }
    @When("I enter a username {string}")
    public void i_enter_a_username(String string) {
    }
    @And("I enter a password {}")
    public void i_enter_a_password_webdriver123(String password) {
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {
    }
    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {

    }
}
