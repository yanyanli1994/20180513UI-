package Test20180408_Protice2.TestData;

import Test20180408_Protice2.AllBrowsers.Browsers;
import Test20180517.BrowsersType;
import ToolsClass.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by Administrator on 2018-05-24.
 * 该类为入口，结合data和locator使用
 */
public class Practice2OnTestNG {
    protected static WebDriver ffwb=null;
    private FirefoxProfile firefoxProfile = null;
    private String projectpath=System.getProperty("user.dir");

    private ParseProperties data;
    private ParseProperties locator;
    private Wait wait;

    @Parameters({"data","locator"})
    @BeforeClass
    public void startFirefox(@Optional("data") String da,@Optional("locl") String loc){
        data =new ParseProperties(System.getProperty("user.dir")+da);
        locator=new ParseProperties(System.getProperty("user.dir")+loc);
        Browsers browser=new Browsers(BrowsersType.firefox);
        ffwb=browser.driver;
        wait=new Wait(ffwb);
    }
    @Test
    public void accessMail(){
        Wait wait=new Wait(ffwb);
        ffwb.get(data.getValue("url"));
        ffwb.findElement(By.xpath(locator.getValue("username"))).clear();
        ffwb.findElement(By.xpath(locator.getValue("username"))).sendKeys(data.getValue("username"));
        ffwb.findElement(By.xpath(locator.getValue("pasword"))).sendKeys(data.getValue("password"));
        wait.waitForElementPresent(locator.getValue("homepage"));
        Assert.assertEquals(ffwb.findElement(By.xpath(locator.getValue("sendbox"))).isDisplayed(),true);
        //ffwb.findElement(By.xpath(locator.getValue("sendbox"))).click();
        wait.waitFor(10000);
    }
    @Test
    public void getUnReadMails(){
        int expectedRes=40;
        String unreadmailnum=ffwb.findElement(By.xpath(locator.getValue("inboxMailsNum"))).getText();
        String str=unreadmailnum.substring(1,unreadmailnum.length()-1);
        int i=Integer.valueOf(str);
        System.out.println(i);
        Assert.assertEquals((expectedRes==i),true);
    }
    @AfterClass
    public void release(){
        ffwb.quit();
    }
}
