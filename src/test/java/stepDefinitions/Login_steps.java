package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Login_PO;

import static driver.drivers.DriverFactory.getDriver;


public class Login_steps extends Base_PO {

    private WebDriver driver= getDriver();
    private Login_PO login_po = new Login_PO();


    public Login_steps(Login_PO login_po) {
        this.login_po = login_po;
    }

    @Given("I access the webdriver university login page")
    public void i_access_the_webdriver_university_login_page(){
        //driver.get("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        //navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
        login_po.navigateTo_webDriverUniversity_login_page();
    }
//    @When("I enter a username {string}")
//    public void i_enter_a_username(String username) {
//        driver.findElement(By.id("text")).sendKeys(username);
//    }

    @When("I enter a username {string}")
    public void i_enter_a_unique_username(String username) {

        //driver.findElement(By.id("text")).sendKeys(username);
        login_po.setUserName(username);
    }

    @And("I enter a password {string}")
    public void i_enter_a_password_webdriver123(String password) {
        //driver.findElement(By.id("password")).sendKeys(password);
        login_po.setPassword(password);
    }
    @And("I click on the login button")
    public void i_click_on_the_login_button() {

        driver.findElement(By.id("login-button")).click();
    }
    @Then("I should be presented with the successful login message")
    public void i_should_be_presented_with_the_successful_login_message() {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, "validation succeeded");
    }

    @Then("I should be presented with the unsuccessful login message")
    public void i_should_be_presented_with_the_unsuccessful_login_message() {
        String login_message = driver.switchTo().alert().getText();
        Assert.assertEquals(login_message, "validation failed");
    }
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
        String loginMessage = driver.switchTo().alert().getText();
        Assert.assertEquals(loginMessage.trim(), expectedMessage.trim());
    }

//    @Then("I should be presented with the following login validation message {string}")
//        public void i_should_be_presented_with_the_following_login_validation_message(String expectedMessage) {
//        String loginMessage = driver.switchTo().alert().getText();
//        driver.switchTo().alert().accept();
//        Assert.assertEquals(loginMessage, expectedMessage);
//    }

}
