package ToolsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Administrator on 2018-05-10.
 * 元素等待时间工具类
 * 我们可能碰到什么情况了
 1）等待一个元素的加载
 2）等待一个元素有效
 基本这两个是常用的，也可以覆盖90%的等待问题 全局等待超时
 ffwb.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);//定义全局的等待超时间。
 我们可以将所有等待放到一个这个类我们叫做Wait中这样我们就可以直接使用了
 sleep等待10s和网页不同步，不管数据出不出来都会等10s浪费效率
 而waitElementFor元素出来就可以下一步操作
 */
public class Wait {
    private WebDriver driver;
    private int timeout=10;
    public Wait(WebDriver driver){
        this.driver = driver;
        //PageFactory.initElements(driver,this);
    }
    public void waitForElementPresent(String locator){
        try {
            (new WebDriverWait(driver, timeout)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
        }catch (Exception e){

        }
    }
    public void waitForElementIsEnable(String locator){
        (new WebDriverWait(driver,10)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
    }
    public void waitFor(long timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
