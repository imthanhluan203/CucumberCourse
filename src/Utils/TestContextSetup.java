package Utils;

import PageObjects.LandingPage;
import PageObjects.OfferPage;
import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class TestContextSetup {
    public WebDriver driver;
    public String productNameLandingPage;
    public PageObjectManager pageObjectManager;
    public TestBase testBase;
    public TestContextSetup() {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.manageWebdriver());
    }

}
