package functionalTest;

import CommonElements.FilterElement;
import MainPage.MainPage;
import homeworks.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindCity {

    MainPage mainPage;
    FilterElement filterElement;
    String cityName = "Kiev";


    WebDriver webDriver = new FirefoxDriver();





    @Test
    public void findCity() throws InterruptedException {
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
