package functionalTest;

import BookingComPages.CommonElements.FilterElement;
import BookingComPages.MainPage.MainPage;
import Common.utils.Log4Test;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindCity extends FunctionalTest {

    private static ChromeDriverService service;
    MainPage mainPage;
    FilterElement filterElement;
    String cityName = "Kiev";
//    WebDriverWraper webDriver = new WebDriverFactory().initDriver("chrome");

  @Test
    public void findCity() throws InterruptedException {
        mainPage = new MainPage(webDriver);
        filterElement = new FilterElement(webDriver);
        Log4Test.info("positive findcity " + cityName);
        mainPage.getMainPage();
        filterElement.setCityField(cityName);
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        filterElement.setFirstAutoComplete();
        filterElement.submitSearch();

    }
}
