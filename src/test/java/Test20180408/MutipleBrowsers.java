package Test20180408;

import Test20180408.AllBrowsers.*;
import Test20180517.*;
import Test20180517.BrowsersType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-22.
 * 结合testMutipleBrowseSuite.xml使用
 */
public class MutipleBrowsers {
//    @Parameters({"platform"})
//    @BeforeMethod(groups = "browsers")
//    public void inital(String platform){
//        if (platform.equals("FF"))
//            browser= new Browsers(BrowsersType.firefox);
//        else if (platform.equals("chrome"))
//            browser= new Browsers(BrowsersType.chrome);
//        else
//            browser= new Browsers(BrowsersType.ie);
//            driver=browser.driver;
//    }
    @BeforeMethod(groups = "browsers")
    public void inital(){
        browser = new Test20180408.AllBrowsers.Browsers(BrowsersType.firefox);
        driver = browser.driver;
    }
    @Test(groups = "submodule1")
    public void submodule1(){
        driver.get("http://www.baidu.com");
        System.out.println("---testSubModule1--");
    }
    @Test(groups = "submodule2")
    public void submodule2(){
        driver.get("http://www.bing.com");
        System.out.println("---testSubModule2--");
    }
    @Test(groups = "submodule3")
    public void submodule3(){
        driver.get("http://www.so.com");
        System.out.println("---testSubModule3--");
    }
    @Test(groups = "submodule4")
    public void submodule4(){
        driver.get("http://www.oracle.com");
        System.out.println("---testSubModule4--");
    }
    @AfterMethod(groups = "browsers")
    public void release(){
        driver.quit();
    }
}
