package Test20180501;

import ToolsClass.Wait;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018-05-06.
 * 测试一号店，加入Assert断言
 */
public class Test1HaoDian {
    String projectpath=System.getProperty("user.dir");
    FirefoxProfile firefoxProfile;
    FirefoxDriver ffwb = new FirefoxDriver(firefoxProfile);
    private ParseProperties data=new ParseProperties(System.getProperty("user.dir")+"\\tool\\test1HaoDian.properties");
    private ParseProperties locator=new ParseProperties(System.getProperty("user.dir")+"\\tool\\locators.properties");
    @BeforeClass
    public void startFirefox(){
        File firebug = new File(projectpath+"/tool/firebug-1.8.4-fx.xpi");
        File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
        firefoxProfile = new FirefoxProfile();
        try {
            firefoxProfile.addExtension(firebug);
            firefoxProfile.addExtension(firepath);
            firefoxProfile.setPreference("webdriver.accept.untrusted.certs","true");
            firefoxProfile.setPreference("extensions.firebug.currentVersion","1.8.4");
            ffwb = new FirefoxDriver(firefoxProfile);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchMerchandise(){
        System.out.println(data.getTestData("url"));
        System.out.println("ffwb"+ffwb);
        Wait wait = new Wait(ffwb);
        ffwb.get(data.getTestData("url"));
        ffwb.findElement(By.xpath(locator.getTestData("SearchBox"))).sendKeys(data.getTestData("merchandise"));
        ffwb.findElement(By.xpath(locator.getTestData("SearchBtn"))).click();
        WebElement we = ffwb.findElement(By.xpath(locator.getTestData("Item")));
        wait.waitForElementPresent(locator.getTestData("Item"));
        Assert.assertEquals(we.isDisplayed(),false);
    }

}
