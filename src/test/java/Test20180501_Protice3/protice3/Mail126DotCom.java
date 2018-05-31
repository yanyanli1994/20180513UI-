package Test20180501_Protice3.protice3;

import Test20180408_Protice2.AllBrowsers.Browsers;
import Test20180408_Protice2.TestData.ParseProperties;
import Test20180517.BrowsersType;
import Test20180517.Do;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-31.
 */
public class Mail126DotCom {
    private WebDriver driver;
    private ParseProperties data;
    private Do du;
//初始化方法
    @BeforeClass
    public void inital(){
     data=new ParseProperties(System.getProperty("user.dir")+"\\tool\\test.properties");
        Browsers browser=new Browsers(BrowsersType.firefox);
        driver=browser.driver;
        du=new Do(driver);
    }
    //登录126邮箱方法
    @Test
    public void login126site(){
        driver.get("http://www.126.com");
        du.what("username").sendKeys("FireflyAutomation");
        du.what("password").sendKeys("Firefly", Keys.ENTER);
        //du.what("submit").click();
        du.waitForeElementPresent("inbox");
        du.waitFor(5000);
    }
    //定义实际未读页数  定义翻页
    //获取总的页数 进行翻页操作
    @Test(dependsOnMethods = {"login126site"})
    public void restrivalMailsIn(){
        int actualunreadMailsNum=0;
        int totalPagesNum=0;
        String strNum=du.what("inboxMailsNum").getText();
        int inboxunReadMailsNum=Integer.valueOf(strNum.substring(1,strNum.length()-1));

        du.what("inbox").click();
        du.waitForeElementPresent("unreadLink");
        du.what("unreadLink").click();
        du.waitForeElementPresent("totalPages");
        totalPagesNum=Integer.valueOf(du.what("totalPages").getText().split("/")[1]);
        while(totalPagesNum>=1){
            actualunreadMailsNum=actualunreadMailsNum+du.whats("unreadMails").size();
//            try{
//
//            }
        }

    }
}
