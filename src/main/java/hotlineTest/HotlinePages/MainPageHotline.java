package hotlineTest.HotlinePages;

import homeworks.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPageHotline {
    private WebDriver webDriver;
    private WebElement REGISTER_LINK;
    private WebElement LOGIN_LINK;
    private WebElement SEARCH_STRING;
    private WebElement searchButton;
    private WebElement closeVisaBanner;
    private WebElement closeCity;
    private WebElement bt;
    private WebElement refrigerator;
    private String WebSiteName;

    public MainPageHotline(WebDriver webDriver) {
        Log4Test.info("get main page");
        this.webDriver = webDriver;
        this.WebSiteName = "http://hotline.ua/";

    }

    public void pressRegisterLink() {
        Log4Test.info("press registerlink");
        getREGISTER_LINK().click();
    }

    public void serchProduct(String productName) {
        Log4Test.info("type " + productName + "in serchField and find it");
        getSEARCH_STRING().sendKeys(productName);
        getSearchButton().submit();
    }

    public void getMainPage() {
        webDriver.get(WebSiteName);
    }

    public WebElement getREGISTER_LINK() {
        return REGISTER_LINK = webDriver.findElement(By.className("reg"));
    }

    public WebElement getSEARCH_STRING() {
        return SEARCH_STRING = webDriver.findElement(By.id("searchbox"));
    }

    public WebElement getBt(){
        return bt = webDriver.findElement(By.xpath("//a[@href='/bt/']"));
    }

    public WebElement getRefrigerator(){
        return refrigerator = webDriver.findElement(By.xpath("//a[@href='/bt/holodilniki/']"));
    }

    public WebElement getSearchButton() {
        return searchButton = webDriver.findElement(By.id("doSearch"));
    }

    public void choseCategory(WebElement webElement){
        Log4Test.info("move to category");
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement);
        actions.perform();
    }

    public void pressRefrigeratorLink(){
        Log4Test.info("pressRefrigiratorLink");
        getRefrigerator().click();
    }

    public WebElement getCloseVisaBanner() {
        closeVisaBanner = webDriver.findElement(By.id("lightbox-form")).findElement(By.tagName("span"));
        return closeVisaBanner;
    }

}
