package Test20180408;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2018-05-01.
 * 一、浏览器版本和驱动一定要统一：我这里浏览器版本是火狐46.0.1，驱动版本是2.40.0（详情见pom.xml文件）
 * 二、使用selenium 2.52.0+firefox 47.0.1时，出现以下两种情况时：
 *1、org.openqa.selenium.firefox.NotConnectedException: Unable to connect to host 127.
 *2、org.openqa.selenium.WebDriverException: Failed to connect to binary FirefoxBinary
 *解决方案：
 *1、目前还没有selenium jar适应firefox 47.0.1，所以需要降低火狐版本，我降低为firefox 46.0.1(先卸载firefox 47.0.1，再安装firefox 46.0.1)
 *2、往Java工程中，导入selenium-server-standalone-2.52.0.jar、selenium-java-2.52.0.jar、selenium-java-2.52.0-srcs.jar和lib文件夹下所有jar包。
 */
public class LaunchFireFox {
    private WebDriver ffwb=null;
    private FirefoxProfile firefoxProfile=null;
    private String projectpath=System.getProperty("user.dir");
    @BeforeClass
    public void startFirefox(){
        File firebug = new File(projectpath+"\\src\\test\\drivertool\\firebug-1.8.4.xpi");
        File firepath = new File(projectpath+"\\src\\test\\drivertool\\firepath-0.9.7-fx.xpi");
        firefoxProfile=new FirefoxProfile();
        try {
            firefoxProfile.addExtension(firebug);
            firefoxProfile.addExtension(firepath);
            firefoxProfile.setPreference("webdriver.accept.untrusted.certs", "true");
            firefoxProfile.setPreference("extensions.firebug.currentVersion", "1.12.1");
            firefoxProfile.setPreference("network.proxy.type", 0);
            firefoxProfile.setPreference("network.proxy.type", "10.1.1.0");
            firefoxProfile.setPreference("network.proxy.http_port", 3128);
        }catch (IOException e){
            e.printStackTrace();
        }
        ffwb=new FirefoxDriver(firefoxProfile);
    }
    @Test
    public void searchOnBaidu(){
        ffwb.get("http://www.baidu.com");
        //System.out.println(Locator.username1);
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @AfterClass
    public void releaseFFDriver(){
        ffwb.quit();
    }

}