package scripts;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.TechGlobalFrontendTestingPage;
import pages.TechGlobalLoginFormPage;
import utilities.LoginUtils;

public class TechGlobalLoginFormTest extends TechGlobalHome{


    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingPage = new TechGlobalFrontendTestingPage();
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalFrontendTestingPage.getFrontendTestingPage();
        techGlobalFrontendTestingPage.clickOnCard(15);
    }


    @Test(priority = 1, description = "Validating Login Form")
    public void validateTechGlobalLoginFormCard(){
        Assert.assertEquals(techGlobalLoginFormPage.heading1.getText(), "Login Form");
        Assert.assertEquals(techGlobalLoginFormPage.usernameLabel.getText(), "Please enter your username");
        Assert.assertTrue(techGlobalLoginFormPage.usernameInputBox.isDisplayed());
        Assert.assertEquals(techGlobalLoginFormPage.passwordLabel.getText(), "Please enter your password");
        Assert.assertTrue(techGlobalLoginFormPage.passwordInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isEnabled());
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.forgotPasswordLink.isEnabled());
    }


    @Test(priority = 2, description = "Valid login")
    public void validLogin(){
        LoginUtils.login("TechGlobal", "Test1234");
        Assert.assertEquals(techGlobalLoginFormPage.loggedInMessage.getText(), "You are logged in");
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.logoutButton.isEnabled());
    }


    @Test(priority = 3, description = "Valid login then logout")
    public void loginLogout(){
        LoginUtils.login("TechGlobal", "Test1234");
        techGlobalLoginFormPage.logoutButton.click();
        Assert.assertEquals(techGlobalLoginFormPage.heading1.getText(), "Login Form");
        Assert.assertTrue(techGlobalLoginFormPage.loginButton.isDisplayed());
    }


    @Test(priority = 4, description = "Forgot Password Link and Reset")
    public void validateForgotPassword(){
        techGlobalLoginFormPage.forgotPasswordLink.click();
        Assert.assertEquals(techGlobalLoginFormPage.resetHeading.getText(), "Reset Password");
        Assert.assertEquals(techGlobalLoginFormPage.resetMessage.getText(), "Enter your email address and we'll send you a link to reset your password.");
        Assert.assertTrue(techGlobalLoginFormPage.emailInputBox.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isDisplayed());
        Assert.assertTrue(techGlobalLoginFormPage.submitButton.isEnabled());
    }


    @Test(priority = 5, description = "Validate reset password email functionality")
    public void checkResetEmail(){
        techGlobalLoginFormPage.forgotPasswordLink.click();
        techGlobalLoginFormPage.emailInputBox.sendKeys("branko.cukuranovic@gmail.com");
        techGlobalLoginFormPage.submitButton.click();
        Assert.assertEquals(techGlobalLoginFormPage.resetConfirmationMessage.getText(), "A link to reset your password has been sent to your email address.");
    }


    @Test(priority = 6, description = "Validate invalid login with wrong username")
    public void validateInvalidUsername(){
        LoginUtils.login("john", "Test1234");
        Assert.assertEquals(techGlobalLoginFormPage.invalidCredentialMessage.getText(), "Invalid Username entered!");
    }


    @Test(priority = 7, description = "Validate invalid login with wrong password")
    public void validateInvalidPassword(){
        LoginUtils.login("TechGlobal", "1234");
        Assert.assertEquals(techGlobalLoginFormPage.invalidCredentialMessage.getText(), "Invalid Password entered!");
    }


    @Test(priority = 8, description = "Validate invalid login with both wrong credentials")
    public void validateInvalidBothCredentials(){
        LoginUtils.login("john", "1234");
        Assert.assertEquals(techGlobalLoginFormPage.invalidCredentialMessage.getText(), "Invalid Username entered!");
    }


}
