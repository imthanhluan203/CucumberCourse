package PageObjects;

import Utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

    private By linkToOfferPage = By.xpath("//a[text()='Top Deals']");
    private By searchTextBox = By.xpath("//input[@type='search']");
    private String dynamicProductName = "//h4[contains(text(),'%s')]";
    private WebDriver webDriver;

    public LandingPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public void searchProduct(String name){
        webDriver.findElement(searchTextBox).sendKeys(name);
    }
    public String getNameProduct(String name){
        By locator = By.xpath(String.format(dynamicProductName,name));
        String productName = new Helpers(webDriver).waitStrategy(locator).getText();
        return productName;
    }

    public void switchToOfferPage(){
        webDriver.findElement(linkToOfferPage).click();
        new OfferPage(webDriver).switchToOfferPage();
    }
}
