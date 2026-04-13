package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver webDriver;
    public PageObjectManager(WebDriver webDriver){
        this.webDriver = webDriver;
    }
    public LandingPage getLandingPage(){
        return new LandingPage(webDriver);
    }
    public OfferPage getOfferPage(){
        return new OfferPage(webDriver);
    }
}
