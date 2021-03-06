package BookingComPages.ResultPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultPage {

    private WebDriver webDriver;
    private List<WebElement> cities ;
    private int DEFAULT_SIZE = 15;

    public List<WebElement> getCities(String cityName) {
        cities = webDriver.findElements(By.xpath("//div[@class='address']//a[contains(., '"+ cityName + "')]"));
        return cities;
    }

    public ResultPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public boolean isResultContainsCity(String cityName){
        if (getCities(cityName).size() == DEFAULT_SIZE) return true;
        return false;
    }



}
