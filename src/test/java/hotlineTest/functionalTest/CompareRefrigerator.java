package hotlineTest.functionalTest;

import functionalTest.FunctionalTest;
import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPageHotline;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class CompareRefrigerator extends FunctionalTest {
    WebDriver webDriver;
    MainPageHotline mainPageHotline;
    GoodsPage goodsPage;

    @BeforeClass
    public void initDriver() {
        webDriver = FunctionalTest.webDriver.getOriginalDriver();
    }

    @BeforeMethod
    public void setup() {
        mainPageHotline = new MainPageHotline(webDriver);
    }

    @Test(priority = 5)
    public void comprateTwoPrices(){
        mainPageHotline.getMainPage();
        mainPageHotline.choseCategory(mainPageHotline.getBt());
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        mainPageHotline.pressRefrigeratorLink();
        goodsPage = new GoodsPage(webDriver);
        goodsPage.moveMouseDown(5);
        goodsPage.FilterMark("LG");
        goodsPage.sortBy("возрастанию цены");
        Assert.assertTrue(goodsPage.compareprice());
    }


}
