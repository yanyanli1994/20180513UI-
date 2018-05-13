package Test20180408;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Administrator on 2018-05-01.
 */
public class LaunchChrome {
    private WebDriver chromewb=null;
    private DesiredCapabilities caps=null;
    private String projectpath=System.getProperty("user.dir");

    @BeforeClass
    public void startChrome(){
        System.setProperty("webdriver.chrome.driver",projectpath+"/tool/chromedriver.exe");
        caps=DesiredCapabilities.chrome();
        caps.setCapability("chrome.switches", Arrays.asList("--start-maximized"));
    }
    @Test
    public void searchOnBaidu(){
        chromewb=new ChromeDriver(caps);
        chromewb.get("http://www.baidu.com");
    }
    @AfterClass
    public void releaseChromeDriver(){
        chromewb.quit();
    }

}
