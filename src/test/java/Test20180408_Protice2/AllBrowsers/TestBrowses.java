package Test20180408_Protice2.AllBrowsers;
import Test20180517_Protice5.BrowsersType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-22.
 * 测试未通过，需要继续更改
 */
public class TestBrowses {
    private WebDriver driver;
    private APIObject testlinkapi;
    private String caseName;

    @BeforeClass
    public void beforeClass(){
        Browsers browsers=new Browsers(BrowsersType.chrome);
        driver=browsers.driver;
    }
    @Test
    public void start(){
        caseName="DoOne";
        driver.get("http:www.126.com");
        driver.findElement(By.name("email")).clear();
        driver.findElements(By.xpath(".//*[@name='email']")).clear();
        driver.findElement(By.xpath(".//*[@name='email']")).sendKeys("FireflyAutomation");
        driver.findElement(By.xpath("//input[@id='pwdInput']")).sendKeys("Firefly");
        driver.findElement(By.xpath("//input[@id='pwdInput']")).submit();
        Assert.assertEquals(true,true);
    }
    @AfterMethod
    public void import2TestLink(ITestResult res){
        testlinkapi.getAPI();
        testlinkapi.getTestCases();
        testlinkapi.executeTestCase(caseName,res.getStatus(),"Luter deose!");
    }
}
