package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TechGlobalLoginFormPage extends TechGlobalHomePage{

    public TechGlobalLoginFormPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "main_heading")
    public WebElement heading1;

    @FindBy(css = "label[for='username']")
    public WebElement usernameLabel;

    @FindBy(id = "username")
    public WebElement usernameInputBox;

    @FindBy(css = "label[for='password']")
    public WebElement passwordLabel;

    @FindBy(id = "password")
    public WebElement passwordInputBox;

    @FindBy(id = "login_btn")
    public WebElement loginButton;

    @FindBy(id = "forgot-password")
    public WebElement forgotPasswordLink;

    @FindBy(id = "success_lgn")
    public WebElement loggedInMessage;

    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "sub_heading")
    public WebElement resetHeading;

    @FindBy(xpath = "//input[@id='email']/../label")
    public WebElement resetMessage;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(id = "confirmation_message")
    public WebElement resetConfirmationMessage;

    @FindBy(id = "error_message")
    public WebElement invalidCredentialMessage;

}
