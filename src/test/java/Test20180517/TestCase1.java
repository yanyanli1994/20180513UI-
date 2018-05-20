package Test20180517;

import ToolsClass.Wait;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

/**
 * Created by Administrator on 2018-05-19.
 */
public class TestCase1 {
    //调用HomePage访问京东页面
    private WebDriver driver;
    //private Do du;
    @BeforeClass
    public void inialize(){
        Browsers browser = new Browsers(BrowsersType.firefox);
        driver=browser.driver;
        //do = new Do(driver);
        driver.manage().window().maximize();
    }
    @Test
    public void regAccount(){
       // Wait wait= new Wait(ffwb);
        //RegisterOnJD reg = new RegisterOnJD(driver);
        driver.get("http://www.jd.com");
        RegOnJD reg = new RegOnJD(driver);
        HomePage homepage = new HomePage(driver);
        homepage.register();

        homepage.navigateToJD("http://www.jd.com");
        homepage.register();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //reg.setAccountName("testRD");
        //reg.seyPassword("admin123");
        //reg.submit();
        //Assert.asserEquals(reg.getWebElement().isDisplayed(),true);
    }
}
