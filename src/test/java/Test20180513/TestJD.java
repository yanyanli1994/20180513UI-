package Test20180513;

import ToolsClass.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Administrator on 2018-05-13.
 * 下拉列表选择
 */
public class TestJD {
    @Test
    public void selectItemFromDropDownList(){
        FirefoxDriver ffwb = new FirefoxDriver();
        Wait wait = new Wait(ffwb);
        //登录jd官方网站
        ffwb.get("http://www.jd.com");
        wait.waitForElementPresent("//a[text()='[登录]']");
        //登录用户信息
        wait.waitForElementPresent("//input[@id='loginname']");
        ffwb.findElement(By.xpath("//input[@id='loginname']")).sendKeys("test201301@mailinator.com");
        ffwb.findElement(By.xpath("//input[@id='nloginpwd']")).sendKeys("admin123");
        ffwb.findElement(By.xpath("//input[@id='loginsubmit']")).click();
        //登录个人信息
        ffwb.findElement(By.xpath("//a[text()='我的订单']")).click();
        ffwb.findElement(By.xpath("//a[text()='账户信息']")).click();
        //选择上海作为它的province
        Select province = new Select(ffwb.findElement(By.xpath("//select[@id='province']")));
        province.selectByVisibleText("上海");
        wait.waitFor(3000);
        //打印上海下的所有区域
        Select city = new Select(ffwb.findElement(By.xpath("//select[@id='city']")));
        List<WebElement> allcitys=city.getOptions();
        for (WebElement eachcity:allcitys){
            System.out.println(eachcity.getText());
        }
    }
}
