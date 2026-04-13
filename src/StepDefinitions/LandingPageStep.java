package StepDefinitions;

import PageObjects.LandingPage;
import Utils.Helpers;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LandingPageStep {
    private String productNameOfferPage;
    private TestContextSetup testContextSetup;

    public LandingPageStep(TestContextSetup testContextSetup){
        this.testContextSetup = testContextSetup;
    }


    @Given("User in on Green Card Landing page")
    public void user_in_on_green_card_landing_page() {
        System.out.println("User in on Green Card Landing page");
    }
    @When("^User search with short name (.+) and extract actual name of product$")
    public void user_search_with_short_name_and_extract_actual_name_of_product(String string) {
        System.out.println("User search with short name {string} and extract actual name of product: " + string);
        this.testContextSetup.pageObjectManager.getLandingPage().searchProduct(string);
        this.testContextSetup.productNameLandingPage = this.testContextSetup.pageObjectManager.getLandingPage().getNameProduct(string).split("-")[0].trim();
    }

}
