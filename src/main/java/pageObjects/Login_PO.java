package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{

    //step definitions
    private @FindBy(id = "text")
    WebElement userName_textField;

    private @FindBy(id = "password")
    WebElement password_textField;

    private @FindBy(id = "login-button")
    WebElement login_Button;


    public Login_PO() {
        super();
    }
    //step definitions
    public void navigateTo_webDriverUniversity_login_page(){
        navigateTo_URL("https://www.webdriveruniversity.com/Login-Portal/index.html?");
    }

    public void setUserName(String userName){
        sendKeys(userName_textField,userName);
    }

    public void setPassword(String password){
        sendKeys(password_textField,password);
    }

    public void clickOn_Login_Button(){
        waitForWebElementAndClick(login_Button);
    }

    public void validate_SuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation succeeded");
    }

    public void validate_UnsuccessfulLogin_Message(){
        waitForAlert_And_ValidateText("validation failed");
    }

}
