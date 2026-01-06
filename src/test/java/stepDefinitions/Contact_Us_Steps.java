package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;

import static driver.drivers.DriverFactory.getDriver;

public class Contact_Us_Steps extends Base_PO {
//    private WebDriver driver;
//
//    //in here- before test get executed opening chrome
//    @Before("@contact_us")
//    public void setup(){
//
//        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/main/java/drivers/chromedriver.exe");
//        System.setProperty(
//                "webdriver.chrome.driver",
//                System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe"
//        );
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
//        driver = new ChromeDriver(chromeOptions);
//        driver.manage().window().maximize();
//    }
//    //After test finishg close the chrome browser
//    @After("@contact_us")
//    public void tearDown(){
//        driver.quit();
//    }

    private WebDriver driver= getDriver();

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        //driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
    @When("I enter unique first name")
    public void i_enter_unique_first_name() {
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + genrerateRandomNumber(5));
        sendKeys(By.xpath("//input[@name='first_name']"),"AutoFN" + genrerateRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + genrerateRandomNumber(5));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + genrerateRandomNumber(10) + "@mail.com");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world" + genrerateRandomString(10));
    }


    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }
    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }
    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
    }
    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }
    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value='SUBMIT']")).click();
    }
    @Then("I should be presented with a successful contact us submision message")
    public void i_should_be_presented_with_a_successful_contact_us_submision_message() {
        WebElement contactUs_Submission_Message= driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }

}
