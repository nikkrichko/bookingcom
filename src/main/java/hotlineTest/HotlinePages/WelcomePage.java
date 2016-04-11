package hotlineTest.HotlinePages;

import homeworks.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WelcomePage {

    WebDriver webDriver;
    private WebElement WELCOME_PAGE_FIRST_NAME;
    private WebElement WELCOME_PAGE_SECOND_NAME;

    public WelcomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        Log4Test.info("find field on welcome page");
        WELCOME_PAGE_FIRST_NAME = webDriver.findElement(By.name("first_name"));
        WELCOME_PAGE_SECOND_NAME = webDriver.findElement(By.name("last_name"));
    }

    public WebElement getWELCOME_PAGE_FIRST_NAME() {
        return WELCOME_PAGE_FIRST_NAME;
    }

    public WebElement getWELCOME_PAGE_SECOND_NAME() {
        return WELCOME_PAGE_SECOND_NAME;
    }




}
