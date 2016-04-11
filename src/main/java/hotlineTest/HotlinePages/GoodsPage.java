package hotlineTest.HotlinePages;

import homeworks.utils.Log4Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.awt.*;

public class GoodsPage {

    WebDriver webDriver;
    private WebElement good;
    private WebElement priceButton;

    public GoodsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement getGoods(String goodName) {
        return good = webDriver.findElement(By.xpath("//*[.='" + goodName + "']"));
    }

    public void productPrice(){
        priceButton = webDriver.findElement(By.className("price"))
                .findElement(By.className("but-box"));
        priceButton.click();
    }

    public boolean isElementPresent(String goodName) {
        try {
            webDriver.findElement(By.xpath("//*[.='" + goodName + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void moveMouseDown(int i)    {
        Log4Test.info("move mouse");
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.setAutoDelay(500);
        robot.mouseWheel(i);
        robot.setAutoDelay(500);
    }

    public void FilterMark(String mark){
        Log4Test.info("find current refrigerator mark");
        webDriver.findElement(By.xpath("//*[@id='filters']//a[contains(text(),'" + mark + "')]")).click();
    }

    public void sortBy(String sortType){
        webDriver.findElement(By.className("ddopener")).click();
        webDriver.findElement(By.xpath("//a[contains(text(),'" + sortType + "')]")).click();
    }

    public int priceGetter(WebElement element){
        Log4Test.info("get price");
        int value = 0;
        String stringValue = element.getText().substring(0,1) + element.getText().substring(2,5);
        return value = Integer.parseInt(stringValue);
    }

    public WebElement findFirstPrice(){
        Log4Test.info("find first price");
        WebElement element =  webDriver.findElement(By.xpath("//*[@class='orng']"));
        return element;
    }

    public WebElement findSecondPrice(){
        Log4Test.info("find second price");
        WebElement element =   webDriver.findElement(By.xpath("(//*[@class='orng'])[2]"));
        return element;
    }

    public boolean compareprice(){
        Log4Test.info("compare price");
        if(priceGetter(findFirstPrice()) < priceGetter(findSecondPrice())) return true;
        return false;
    }
}
