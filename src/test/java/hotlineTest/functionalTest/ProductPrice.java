package hotlineTest.functionalTest;

import functionalTest.FunctionalTest;
import hotlineTest.HotlinePages.GoodsPage;
import hotlineTest.HotlinePages.MainPageHotline;
import hotlineTest.HotlinePages.ProductPage;
import Common.utils.Log4Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductPrice extends FunctionalTest {

    String product = "iPhone";
    MainPageHotline mainPageHotline;
    GoodsPage goodsPage;
    ProductPage productPage;

    @BeforeMethod
    public void initTest(){
        mainPageHotline = new MainPageHotline(webDriver);
        mainPageHotline.getMainPage();
        mainPageHotline.serchProduct(product);
    }

    @Test
    public void OneThanOnePrice(){
        Log4Test.info("positive check that one than one price");
        goodsPage = new GoodsPage(webDriver);
        goodsPage.productPrice();
        productPage = new ProductPage(webDriver);
        Assert.assertTrue(productPage.isMoreThanOnePrice());
    }
}
