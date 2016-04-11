package hotlineTest.functionalTest;

import functionalTest.FunctionalTest;
import hotlineTest.HotlinePages.MainPageHotline;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenshot extends FunctionalTest {
    MainPageHotline mainPageHotline;

    @BeforeMethod
    public void setup() throws NoSuchMethodException {
        mainPageHotline = new MainPageHotline(webDriver);
    }

    @Test
    public void TakeScreenShotTest(){
        mainPageHotline.getMainPage();
        screenShotMaker.takeScreenShot("mainpage");

    }
}
