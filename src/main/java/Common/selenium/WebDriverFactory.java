package Common.selenium;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;

public class WebDriverFactory {
    public static final String FIREFOX = "firefox";
    public static final String FIREFOX_REMOTE = "firefox_remote";
    public static final String HTML_UNIT = "htmlunit";
    public static final String CHROME = "chrome";
    public static WebDriverWraper driverWraper = null;
    private static ChromeDriverService service;
    static String PATH_TO_CHROMEDRIVER = "chromedriver.exe";

//    public static WebDriverWraper initDriver(String driverName){
//        WebDriverWraper driverWraper = null;
//        if(driverName.equals(FIREFOX)){
//            driverWraper =  new WebDriverWraper(new FirefoxDriver());
//        } else
//        if (driverName.equals(FIREFOX_REMOTE)){
//            DesiredCapabilities capabilities = DesiredCapabilities.firefox();
//            try {
//                driverWraper = new WebDriverWraper(
//                        new RemoteWebDriver(
//                                new URL(PropertyLoader.loadProperty("selenium.hub")), capabilities));
//            } catch (MalformedURLException e) {
//                e.printStackTrace();
//            }
//        } else
//        if (driverName.equals(HTML_UNIT)){
//            driverWraper = new WebDriverWraper(new HtmlUnitDriver());
//        }
//        if (driverName.equals(CHROME)){
//            driverWraper = new WebDriverWraper(new ChromeDriver());
//        }
//        else {
//            Assert.fail("invalid driver configuration");
//
//        }
//        return driverWraper;
//    }


    public static WebDriverWraper initDriver(String driverName) {
        driverName.toLowerCase();

        if(driverName.equals(FIREFOX)){
            driverWraper =  new WebDriverWraper(new FirefoxDriver());
        }
        if (driverName.equals(CHROME)) {
            initChromeDriver();
        }
        else {
            Assert.fail("invalid driver configuration");
        }

        return driverWraper;
    }

    private static void initChromeDriver() {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                .usingAnyFreePort()
                .build();
        try {
            service.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        driverWraper = new WebDriverWraper(new ChromeDriver());
    }

}
