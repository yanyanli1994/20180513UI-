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
 */
public class LaunchFireFox {
    private WebDriver ffwb=null;
    private FirefoxProfile firefoxProfile=null;
    private String projectpath=System.getProperty("user.dir");
    @BeforeClass
    public void startFirefox(){
        File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
        File firepath = new File(projectpath+"/tool/firepath-1.12.1-fx.xpi");
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