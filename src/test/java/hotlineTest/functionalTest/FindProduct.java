package hotlineTest.functionalTest;

import functionalTest.FunctionalTest;
import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPageHotline;
import homeworks.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by bionic on 11/5/14.
 */
public class FindProduct extends FunctionalTest {


    MainPageHotline mainPageHotline;
    GoodsPage goodsPage;
    String product = "iPhone";
    String noneProduct = "yablophone";

    @BeforeMethod
    public void setup() {
        mainPageHotline = new MainPageHotline(webDriver);
    }

    @Test
    public void findProduct() {
        Log4Test.info("positive findProduct " + product);
        mainPageHotline.getMainPage();
        mainPageHotline.serchProduct(product);
        goodsPage = new GoodsPage(webDriver);
        Assert.assertTrue(goodsPage.getGoods(product).isDisplayed());
    }

    @Test
    public void findProductNegative() {
        Log4Test.info("negative findProduct " + noneProduct);
        mainPageHotline.getMainPage();
        mainPageHotline.serchProduct(noneProduct);
        goodsPage = new GoodsPage(webDriver);
        Assert.assertFalse(goodsPage.isElementPresent(noneProduct));
    }
}
