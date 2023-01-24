package scripts;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TechGlobalFrontendTestingPage;

public class TechGlobalFrontendTestingTest extends TechGlobalHome{

    @BeforeMethod
    public void setPage(){
        techGlobalFrontendTestingPage = new TechGlobalFrontendTestingPage();
        techGlobalFrontendTestingPage.getFrontendTestingPage();
    }



}
