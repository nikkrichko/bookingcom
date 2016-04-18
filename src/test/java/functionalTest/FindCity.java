package functionalTest;

import BookingComPages.CommonElements.FilterElement;
import BookingComPages.MainPage.MainPage;
import BookingComPages.ResultPage.ResultPage;
import Common.utils.Log4Test;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindCity extends FunctionalTestSetup {

    private static ChromeDriverService service;
    MainPage mainPage;
    FilterElement filterElement;
    ResultPage resultPage;
    String cityName = "Киев";

    @BeforeClass
    public void  setupPages(){
        mainPage = new MainPage(webDriver);
        filterElement = new FilterElement(webDriver);
        resultPage = new ResultPage(webDriver);
    }

    @Test
        public void findCity() throws InterruptedException {
            Log4Test.info("positive findcity " + cityName);
            mainPage.getMainPage();
            filterElement.setCityField(cityName);
            filterElement.setFirstAutoComplete();
            filterElement.submitFirstSearch();
            assert (resultPage.isResultContainsCity(cityName));
    }
}
