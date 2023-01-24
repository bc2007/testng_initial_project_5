package utilities;

import org.openqa.selenium.WebDriver;
import pages.TechGlobalLoginFormPage;

public class LoginUtils {

    // WebDriver driver;
    public static TechGlobalLoginFormPage techGlobalLoginFormPage;

    public static void login(String username, String password){
        techGlobalLoginFormPage = new TechGlobalLoginFormPage();
        techGlobalLoginFormPage.usernameInputBox.sendKeys(username);
        techGlobalLoginFormPage.passwordInputBox.sendKeys(password);
        techGlobalLoginFormPage.loginButton.click();
    }

}
