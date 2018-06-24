package Test20180330_Protice1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2018-04-01.
 * 1、请在百度或google中输入selenium找到Selenium - Web Browser Automation 官网
 */
public class Test1 {
    public static void main(String[] args) throws InterruptedException {
        //指定打开浏览器安装路径
        System.getProperty("webdriver.chrome.bin","F:\\IdeaProjects\\UIAutoTest2018\\src\\all_selenium\\chromedriver.exe");
        //创建一个webdriver实例
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.baidu.com/");
        driver.manage().window().maximize();
        WebElement webEle= driver.findElement(By.name("wd"));
        webEle.sendKeys("selenium");
        Thread.sleep(5000);
        driver.findElement(By.id("su")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@id=\"2\"]/h3[@class=\"t c-title-en\"]/a/em[text()='Selenium']")).click();
    }

}
