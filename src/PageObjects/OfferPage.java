package PageObjects;

import Utils.Helpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OfferPage {

    private By searchTextBox = By.xpath("//input[@type='search']");
    private By productText = By.xpath("//tbody//tr//td[count(//th//span[text()='Veg/fruit name']//ancestor::th//preceding-sibling::th) + 1]");
    private WebDriver webDriver;
    public OfferPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void switchToOfferPage(){
        String currentWindow = this.webDriver.getWindowHandle();
        List<String> windowHandles = this.webDriver.getWindowHandles().stream().toList();
        for(String childWindow : windowHandles){
            this.webDriver.switchTo().window(childWindow);
            if(this.webDriver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers")){
                return;
            }
        }
        this.webDriver.switchTo().window(currentWindow);
        return;
    }

    public void searchProduct(String name){
        webDriver.findElement(searchTextBox).sendKeys(name);
    }
    public String getNameProduct(){
        String productName = new Helpers(webDriver).waitStrategy(productText).getText();
        return productName;
    }
}
