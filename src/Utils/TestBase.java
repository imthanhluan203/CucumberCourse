package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestBase {
    private WebDriver webDriver;
    public WebDriver manageWebdriver()  {
        InputStream is = null;
        Properties properties = new Properties();
        try {
            is = new FileInputStream(System.getProperty("user.dir")+"/src/Global.properties");
            properties.load(is);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String driverType = properties.getProperty("BROWSER");
        String urlDefault = properties.getProperty("DEFAULTURL");
        if(webDriver == null){
            if(driverType.equalsIgnoreCase("chrome")){
                webDriver = new ChromeDriver();
            }
            webDriver.get(urlDefault);
        }
        return webDriver;
    }
}
