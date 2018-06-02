package Test20180501_Protice3.protice3;

import ToolsClass.Switch;
import ToolsClass.Wait;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018-05-31.
 */
public class TestCase implements Locators{
    private WebDriver ffwb=null;
    private FirefoxProfile firefoxProfile=null;
    private String projectpath=System.getProperty("user.dir");
    private Wait wait=null;

    @BeforeClass
    public void startFirefox(){
        File firebug =new File(projectpath+"\\src\\test\\drivertool\\firepath-0.9.7-fx.xpi");
        File firepath=new File(projectpath+"\\src\\test\\drivertool\\firebug-1.8.4.xpi");
        firefoxProfile=new FirefoxProfile();
        try {
            firefoxProfile.addExtension(firebug);
            firefoxProfile.addExtension(firepath);
            firefoxProfile.setPreference("webdriver.accept.untrusted.certs","true");
            firefoxProfile.setPreference("extensions.firebug.currentVersion","1.12.1");
            ffwb=new FirefoxDriver(firefoxProfile);
            wait=new Wait(ffwb);
            ffwb.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            ffwb.manage().window().maximize();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    //iframe切换以及滑块坐标拖动
    @Test
    public void changeiFrame(){
        ffwb.get("http://jqueryui.com/slider/");
        wait.waitForElementPresent(JQUERYHOME);
        ffwb.switchTo().frame(ffwb.findElement(By.xpath(SLIDERIFRAME)));
        Point initialPoint=ffwb.findElement(By.xpath(SLIDER)).getLocation();
        System.out.println(initialPoint);

        Actions dragger=new Actions(ffwb);
        dragger.dragAndDropBy(ffwb.findElement(By.xpath(SLIDER)),initialPoint.getX()+569,initialPoint.getY()).build().perform();
        initialPoint=ffwb.findElement(By.xpath(SLIDER)).getLocation();
        System.out.println(initialPoint);
        wait.waitFor(5000);

        ffwb.switchTo().defaultContent();
        ffwb.findElement(By.xpath(DRAGGABLE)).click();
        wait.waitFor(3000);
    }

    //主要目的：登录京东找到辖区上海
    @Test
    public void selectItemFromDropDownList(){
        //登录京东官网
        ffwb.get("http:www.jd.com");
        wait.waitForElementPresent("//a[text()='登录']");
        ffwb.findElement(By.xpath("//a[text()='登录']"));
        //登录用户信息
        wait.waitForElementPresent("//input[@id='loginname']");
        ffwb.findElement(By.xpath("//input[@id='loginname']")).sendKeys("test201301@mailinator.com");
        ffwb.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("admin123");
        ffwb.findElement(By.xpath("//input[@id='loginsubmit']")).click();
        //登录个人信息
        ffwb.findElement(By.xpath("//a[text()='我的订单']")).click();
        ffwb.findElement(By.xpath("//a[text()='账户信息']")).click();

        //选择上海为她得Province
        Select province=new Select(ffwb.findElement(By.xpath("//select[@id='province']")));
        province.selectByVisibleText("上海");
        wait.waitFor(3000);
        //打印上海下的所有区域
        Select city=new Select(ffwb.findElement(By.xpath("//select[@id='city']")));
        List<WebElement> allcitys=city.getOptions();
        for (WebElement eachcity:allcitys){
            System.out.println(eachcity.getText());
        }
    }

    //windows跳转：浏览器打开多个窗口，
    @Test
    public void changeWindows(){
        ffwb.get("http://www.google.com.hk");
       ffwb.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        ffwb.findElement(By.xpath("//input[@name='q']")).submit();
        ffwb.findElement(By.xpath("//a[contains(text(),'-Web Browser Automation')]")).click();
        Switch switchW=new Switch(ffwb);
        switchW.toSpecificWindow("Web Browser Automation");
        ffwb.findElement(By.xpath("//li[@id='menu_documentation']/a[text()='Documentation']")).click();

        switchW.toSpecificWindow("Google");
        ffwb.findElement(By.xpath("//input[@id='lst-ib']")).clear();
        ffwb.findElement(By.xpath("//input[@id='lst-ib']")).sendKeys("eclipse");
        wait.waitFor(5000);
    }

    //鼠标右击功能
    @Test
    public void mouseRightclickContext(){
        ffwb.get("http://www.126.com");
        ffwb.findElement(By.xpath("//input[@id='idInput']")).clear();
        ffwb.findElement(By.xpath("//input[@id='idInput']")).sendKeys("FireflyAutomation");
        ffwb.findElement(By.xpath("//input[@Id='pwdInput']")).sendKeys("Firefly");
        ffwb.findElement(By.xpath("//button[@id='loginBtn']")).click();
        wait.waitFor(5000);
        Actions actions=new Actions(ffwb);
        actions.contextClick(ffwb.findElement(By.xpath("//div/span[text()='收件箱']"))).build().perform();
        wait.waitFor(2000);
        ffwb.findElement(By.xpath("//div[contains(@id,'mail_menu')][last()]/descendant::span[text()='打开']")).click();
        wait.waitFor(2000);
        Assert.assertEquals(ffwb.findElement(By.xpath("//header[@class='frame-main-cont-head']/descentdant::span[text()='举报']")).isDisplayed(),true);
    }
//滚动条操作
    @Test
    public void dragAndDrop(){
        ffwb.get("http://yixuncom");
        Point point=ffwb.findElement(By.xpath("//h2[contains(text(),'3F')]")).getLocation();
        System.out.println(point);
        ((JavascriptExecutor)ffwb).executeScript("window.scrollBy("+point.getX()+","+point.getY()+")");
        wait.waitFor(5000);
  }
//滚动条操作2
    @Test
    public void dragAndDrop2(){
        ffwb.get("http://reg.163.com/agreement.shtml");
        int numberOfPixelsToDragTheScreenbarDown=5000;
        Actions dragger =new Actions(ffwb);
        dragger.moveToElement(ffwb.findElement(By.xpath("//p[contains(text(),'网易通行证服务条款')]"))).clickAndHold().moveByOffset(0,numberOfPixelsToDragTheScreenbarDown);
        wait.waitFor(5000);
    }

    @AfterClass
    public void releaseFFDriver(){
        ffwb.quit();
    }



}
