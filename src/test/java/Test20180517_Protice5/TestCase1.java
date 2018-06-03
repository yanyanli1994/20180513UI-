package Test20180517_Protice5;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-19.
 */
public class TestCase1 {
    //调用HomePage访问京东页面
    private WebDriver driver;
    private Do du;
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
        //RegOnJD reg = new RegOnJD(driver);
        HomePage homepage = new HomePage(driver);
        RegOnJDPage regOnJDPage=new RegOnJDPage(driver);
       // homepage.register();


        homepage.navigateToJD("http://www.jd.com");
        homepage.register();
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        regOnJDPage.serUserId("maz2014");
        regOnJDPage.setPassword("admin123");
        regOnJDPage.register();
        if(regOnJDPage.getRegistedUser().isDisplayed()){
            Assert.assertEquals(true,true);
        }
        //reg.setAccountName("testRD");
        //reg.seyPassword("admin123");
        //reg.submit();
        //Assert.asserEquals(reg.getWebElement().isDisplayed(),true);
    }

    @AfterClass
    public void releaseBrowser(){
        driver.quit();
    }
}
