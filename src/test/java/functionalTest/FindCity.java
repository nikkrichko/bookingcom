package functionalTest;

import BookingComPages.CommonElements.FilterElement;
import BookingComPages.MainPage.MainPage;
import Common.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FindCity {

    private static ChromeDriverService service;
    MainPage mainPage;
    FilterElement filterElement;
    String cityName = "Kiev";
    WebDriver webDriver;
    static String PATH_TO_CHROMEDRIVER = "chromedriver.exe";





    @BeforeMethod
    public static void createAndStartService() throws IOException {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File(PATH_TO_CHROMEDRIVER))
                .usingAnyFreePort()
                .build();
        service.start();
    }

  @Test
    public void findCity() throws InterruptedException {
        webDriver = new ChromeDriver(service);
        mainPage = new MainPage(this.webDriver);
        filterElement = new FilterElement(this.webDriver);
        Log4Test.info("positive findcity " + cityName);
        mainPage.getMainPage();
        filterElement.setCityField(cityName);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        filterElement.setFirstAutoComplete();
        filterElement.submitSearch();

    }
}
