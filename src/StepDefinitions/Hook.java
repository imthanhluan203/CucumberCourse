package StepDefinitions;

import Utils.TestContextSetup;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hook {
    private TestContextSetup testContextSetup;
    public Hook(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }
    @After
    public void clean_up()  {
        this.testContextSetup.testBase.manageWebdriver().quit();
    }

    @AfterStep
    public void takeScreenShort(Scenario scenario){
        WebDriver driver = this.testContextSetup.testBase.manageWebdriver();
        if(scenario.isFailed()){
            byte[] images = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(images,"image/png","image");
        }
    }
}
