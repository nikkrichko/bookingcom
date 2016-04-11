package hotlineTest.functionalTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class GridExample {
    @Test
    public void GridTest(){
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        WebDriver webDriver = null;
        try {
            webDriver = new RemoteWebDriver(new URL("http://localhost:9999/wd/hub"), capabilities);
        } catch (MalformedURLException e){
            e.printStackTrace();
        }
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        webDriver.get("http://hotline.ua");
        webDriver.quit();
    }
}
