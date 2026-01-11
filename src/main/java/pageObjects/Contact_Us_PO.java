package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import utils.Global_Vars;

public class Contact_Us_PO extends Base_PO {

    //two approches
    private @FindBy(how = How.XPATH, using = "//input[@name='first_name']")
    WebElement firstName_TextField;

    //two approches
    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement email_TextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@value='SUBMIT']")
    WebElement submit_Button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement SuccessfulSubmission_Message_Text;


    public Contact_Us_PO() {
        super();
    }

    public void navigateTo_webDriverUniversity_contact_Us_page(){
        navigateTo_URL(Global_Vars.WEBDRIVER_UNIVERSITY_HOMEPAGE_URL +"/Contact-Us/contactus.html");
    }

    public void setUniqueFirstName(){
        sendKeys(firstName_TextField, "AutoFN" + genrerateRandomNumber(5));
    }

    public void setUniqueLastName(){
        sendKeys(lastName_TextField, "AutoLN" + genrerateRandomNumber(5));
    }

    public void setUniqueEmail(){
        sendKeys(email_TextField,"AutoEmail" + genrerateRandomNumber(10) + "@mail.com");
    }

    public void setUniqueComment(){
        sendKeys(comment_TextField,"Hello world" + genrerateRandomString(10));
    }

    public void setSpecificFirstName(String firstName){
        //driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
        sendKeys(firstName_TextField, firstName);
    }

    public void setSpecificLastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }

    public void setSpecificEmailAddress(String emailAddress){
        sendKeys(email_TextField, emailAddress);
    }

    public void setSpecificComment(String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOn_Submit_Button(){
        waitForWebElementAndClick(submit_Button);
    }

    public void validate_Successful_Submission_Message(){
        waitFor(SuccessfulSubmission_Message_Text);
        Assert.assertEquals(SuccessfulSubmission_Message_Text.getText(), "Thank You for your Message!");
    }
}
