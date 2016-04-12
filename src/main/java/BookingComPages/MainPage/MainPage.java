package BookingComPages.MainPage;

import Common.utils.Log4Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver webDriver;
    private String webSiteName;

    @FindBy(id = "")
    private WebElement initElement;

    public MainPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
        this.webSiteName = "http://booking.com/";
        Log4Test.info("get main page: " + webSiteName);
    }

    public void getMainPage(){
        webDriver.get(webSiteName);
    }

}
