package StepDefinitions;

import PageObjects.LandingPage;
import Utils.TestContextSetup;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStep {
    private TestContextSetup testContextSetup;
    private String productNameOfferPage;
    public OfferPageStep(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }


    @Then("User search for same short name in offers page to check if product exist")
    public void user_search_for_same_short_name_in_offers_page_to_check_if_product_exist() {
        System.out.println("User search for same short name in offers page to check if product exist");
        this.testContextSetup.pageObjectManager.getLandingPage().switchToOfferPage();
        this.testContextSetup.pageObjectManager.getOfferPage().searchProduct(this.testContextSetup.productNameLandingPage);
        productNameOfferPage = this.testContextSetup.pageObjectManager.getOfferPage().getNameProduct();
    }
    @Then("Verify product name match with landing page and offer page")
    public void verify_product_name_match_with_landing_page_and_offer_page() {
        Assert.assertEquals(this.testContextSetup.productNameLandingPage,productNameOfferPage,"Verify product name match with landing page and offer page");
    }
}
