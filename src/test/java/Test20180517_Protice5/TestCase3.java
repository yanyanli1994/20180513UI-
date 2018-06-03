package Test20180517_Protice5;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by Administrator on 2018-06-03.
 * 结合NewRegisterPage+NewRegLoc使用
 */
public class TestCase3 {
    private WebDriver driver;
    private NewRegisterPage newregjd;
    private NewHomePage newhome;

    @BeforeClass
    public void inital(){
        Browsers browser=new Browsers(BrowsersType.firefox);
        driver=browser.driver;

        newregjd=new NewRegisterPage(driver);
        newhome=new NewHomePage(driver);
    }

    @Test
    public void regJDAccount(){
        SimpleDateFormat sdf=new SimpleDateFormat();
        String layout="yyyyMMddHHmmss";
        sdf.applyPattern(layout);

        Calendar cl=Calendar.getInstance();
        String accountname=sdf.format(cl.getTime());

        newhome.navigateToJD("http://www.jd.com").register();
        newregjd.setAccountName("test"+accountname).setPasswords("terryselenium_123").submit();
        Assert.assertEquals(newregjd.getWebElement(NewRegLoc.regsuc,"test"+accountname).isDisplayed(),true);
    }

}
