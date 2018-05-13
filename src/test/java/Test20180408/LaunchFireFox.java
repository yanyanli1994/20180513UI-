package Test20180408;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Watchable;

/**
 * Created by Administrator on 2018-05-01.
 */
public class LaunchFireFox {
    private WebDriver ffwb = null;
    private FirefoxProfile firefoxProfile = null;
    private String projectpath = System.getProperty("user.dir");

    @BeforeClass
    public void startFirefox(){
        File firebug = new File(projectpath+"/tool/firebug-1.12.1-fx.xpi");
        File firepath = new File(projectpath+"/tool/firepath-0.9.7-fx.xpi");
        firefoxProfile = new FirefoxProfile();
        try {
            firefoxProfile.addExtension(firebug);//安装Firebug，Firepath
            firefoxProfile.addExtension(firepath);
            firefoxProfile.setPreference("webdriver.accept.untrusted.certs","true");//绕过证书问题
            firefoxProfile.setPreference("extensions.firebug.currentVersion","1.12.1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void searchOnBaidu(){
        ffwb = new FirefoxDriver(firefoxProfile);
        ffwb.get("https://login.providerlink.healthcare.stg.covisint.com/providerlink");
    }
    @AfterClass
    public void releaseFFDriver(){
        ffwb.quit();
    }
}
