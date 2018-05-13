package Test20180408;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-04-16.
 */
public class LaunchIE {
    private WebDriver iewb = null;
    private DesiredCapabilities caps=null;
    private String projectpath = System.getProperty("user.dir");
    //配置IE的DesiredCapabilities
    @BeforeClass
    public void startIE(){
       // System.setProperty("webdriver.ie.driver",projectpath+"/tool/IEDriverServer64.exe");
        System.setProperty("webdriver.ie.driver","F:\\IdeaProjects\\UIAutoTest2018\\tool\\IEDriverSever64.exe");
        caps = DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.FORCE_CREATE_PROCESS,false);
        caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
        caps.setCapability("ignoreZoomSetting",true);
    }
    //启动IE后登陆百度
    @Test
    public void searchOnBaidu(){
        System.out.println(caps);
        iewb = new InternetExplorerDriver(caps);
        iewb.get("http://www.baidu.com");
    }
    //退出IE instance
    @AfterClass
    public void releaseIEDriver(){
        iewb.quit();
    }
}
