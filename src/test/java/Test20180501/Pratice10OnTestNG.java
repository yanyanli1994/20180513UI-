package Test20180501;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.Time;

import static javax.swing.text.html.HTML.Tag.P;

/**
 * Created by Administrator on 2018-05-03.
 * 登录126邮箱
 */
public class Pratice10OnTestNG {
    @Parameters({"TestData"})
    @Test
    public void test(@Optional("") String testdata){
        ParseProperties pp = new ParseProperties(System.getProperty("user.dir")+testdata);
        System.setProperty("webdriver.firefox.marionette","F:\\IdeaProjects\\UIAutoTest2018\\src\\all_selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(pp.getTestData("url"));
        driver.manage().window().maximize();  //浏览器窗口最大化
        driver.switchTo().frame(0);
        driver.findElement(By.xpath(pp.getTestData("username"))).sendKeys(pp.getTestData("usernamevalue"));
        driver.findElement(By.name(pp.getTestData("password"))).sendKeys(pp.getTestData("passwordvalue"));
        driver.findElement(By.xpath(pp.getTestData("login"))).click();
    }
}
