package Test20180501_Protice3.protice3;

import Test20180513.IFrameLocators;
import ToolsClass.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static Test20180513.IFrameLocators.SLIDER;

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
        File firebug =new File(projectpath+"/drivertool/firepath-0.9.7-fx.xpi");
        File firepath=new File(projectpath+"/drivertool/firebug-1.8.4.xpi");
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
}
