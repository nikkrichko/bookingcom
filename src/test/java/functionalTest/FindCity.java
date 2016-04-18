package functionalTest;

import BookingComPages.CommonElements.FilterElement;
import BookingComPages.MainPage.MainPage;
import BookingComPages.ResultPage.ResultPage;
import Common.utils.Log4Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FindCity extends FunctionalTestSetup {

    MainPage mainPage;
    FilterElement filterElement;
    ResultPage resultPage;
    String cityName = "Нью-Йорк";

    @BeforeClass
    public void  setupPages(){
        mainPage = new MainPage(webDriver);
        filterElement = new FilterElement(webDriver);
        resultPage = new ResultPage(webDriver);
    }

    @Test(groups = { "functional", "Positive" })
    public void findCity() throws InterruptedException {
            Log4Test.info("positive findcity  " + cityName);
            mainPage.getMainPage();
            filterElement.inputCityNameInSerchField(cityName);
            filterElement.pressFirstAutoCompleteField();
            filterElement.submitFirstSearch();
            assert (resultPage.isResultContainsCity(cityName));
    }
}
