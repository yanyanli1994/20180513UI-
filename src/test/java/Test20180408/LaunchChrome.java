package Test20180408;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018-05-01.
 */
public class LaunchChrome {
    //记住：包一定要导入testng的，否则容易报空指针
    //google浏览器版本和驱动版本对应访问地址：https://blog.csdn.net/ccggaag/article/details/76094025（我这里用的google浏览器版本58.0.3029.96，驱动版本：2.30）
    private WebDriver chromewb=null;
    private DesiredCapabilities caps=null;
    private String projectpath=System.getProperty("user.dir");
    @BeforeClass
    public void startChrome(){
        System.setProperty("webdriver.chrome.driver",projectpath+"\\src\\test\\drivertool\\chromedriver.exe");
        caps=DesiredCapabilities.chrome();
        caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
        chromewb=new ChromeDriver(caps);
    }
    @Test
    public void searchOnBaidu(){
        chromewb.get("http://www.baidu.com");
    }
    @AfterClass
    public void releaseChromeDriver()
    {
        chromewb.quit();
    }

}
