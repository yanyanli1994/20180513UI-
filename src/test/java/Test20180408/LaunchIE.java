package Test20180408;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-04-16.
 */
public class LaunchIE {
    //注意：如果iewb出现空指针，看下startIE方法是否执行，该注解@BeforeClass导入的包是否是testng包
    private static WebDriver iewb=null;
    private static DesiredCapabilities caps=null;
    private String projectpath =System.getProperty("user.dir");
    //配置IE的DesiredCapabilities
    @BeforeClass
    public void startIE(){
        System.setProperty("webdriver.ie.driver",projectpath+"\\src\\test\\drivertool\\IEDriverServer64.exe");
        caps=DesiredCapabilities.internetExplorer();
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
        caps.setCapability(InternetExplorerDriver.IE_SWITCHES,"-private");
        caps.setCapability("ignoreZoomSetting",true);//IE浏览器放大放小
        iewb=new InternetExplorerDriver(caps);
    }
    //启动IE后登陆百度
    @Test
    public void searchOnBaidu(){
        iewb.manage().window().maximize();
        iewb.get("http://www.baidu.com");
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    //退出IE instance
    @AfterClass
    public void releaseIEDriver(){
       iewb.quit();
    }
}
