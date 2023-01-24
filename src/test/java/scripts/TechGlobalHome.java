package scripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TechGlobalFrontendTestingPage;
import pages.TechGlobalHomePage;
import pages.TechGlobalLoginFormPage;
import utilities.ConfigReader;
import utilities.Driver;

public class TechGlobalHome {

    WebDriver driver;
    TechGlobalHomePage techGlobalHomePage;
    TechGlobalFrontendTestingPage techGlobalFrontendTestingPage;
    TechGlobalLoginFormPage techGlobalLoginFormPage;


    @BeforeMethod
    public void setup(){
        driver = Driver.getDriver();
        techGlobalHomePage = new TechGlobalHomePage();
        driver.get(ConfigReader.getProperty("appURL"));
    }


    @AfterMethod
    public void teardown(){
        Driver.quitDriver();
    }

}
