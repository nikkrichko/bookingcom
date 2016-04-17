package functionalTest;

import BookingComPages.CommonElements.FilterElement;
import BookingComPages.MainPage.MainPage;
import BookingComPages.ResultPage.ResultPage;
import Common.utils.Log4Test;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.Test;

public class FindCity extends FunctionalTestSetup {

    private static ChromeDriverService service;
    MainPage mainPage;
    FilterElement filterElement;
    ResultPage resultPage;
    String cityName = "Киев";
//    WebDriverWraper webDriver = new WebDriverFactory().initDriver("chrome");

    @Test
        public void findCity() throws InterruptedException {
            mainPage = new MainPage(webDriver);
            filterElement = new FilterElement(webDriver);
            resultPage = new ResultPage(webDriver);
            Log4Test.info("positive findcity " + cityName);
            mainPage.getMainPage();
            filterElement.setCityField(cityName);
            filterElement.setFirstAutoComplete();
            filterElement.submitFirstSearch();
            resultPage.isResultContainsCity(cityName);
    }
}
