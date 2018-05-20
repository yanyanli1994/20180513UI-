package Test20180517;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Administrator on 2018-05-20.
 */
public class Browsers {
    public WebDriver driver = null;
    private FirefoxProfile firefoxProfile = null;
    private static DesiredCapabilities caps = null;
    private String projectpath = "G:\\SeleniumTraining1\\FireflyAutomation\\trunk";

    public Browsers(BrowsersType browsertype) {
        switch (browsertype) {
            case firefox:
                File firebug = new File(projectpath + "/tool/firebug-1.12.1-fx.xpi");
                File firepath = new File(projectpath + "/tool/firepath-0.9.7-fx.xpi");
                firefoxProfile = new FirefoxProfile();
                try {
                    firefoxProfile.addExtension(firebug);
                    firefoxProfile.addExtension(firepath);
                    firefoxProfile.setPreference("webdriver.accept.untrusted.certs", true);
                    firefoxProfile.setPreference("extension.firebug.currentVersion", "1.12.1");
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                driver = new FirefoxDriver(firefoxProfile);
                driver.manage().window().maximize();
                break;
            case ie:
                System.setProperty("webdriver.ie.driver", projectpath + "/tool/IEDriverServer32.exe");
                caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS, false);
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                caps.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                caps.setCapability("ignoreZoomSetting", true);
                driver = new InternetExplorerDriver(caps);
                driver.manage().window().maximize();
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", projectpath+"/tool/chromedriver.exe");
                caps=DesiredCapabilities.chrome();
                caps.setCapability("chrome.switched", Arrays.asList("--start-maximized"));
                driver=new ChromeDriver(caps);
                driver.manage().window().maximize();
                break;
        }
    }
}
