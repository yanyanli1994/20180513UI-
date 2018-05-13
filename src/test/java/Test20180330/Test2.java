package Test20180330;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Administrator on 2018-04-08.
 * 2、输入链接https://pypi.python.org/pypi/selenium/2.35.0，定位selenium-2.35.0.tar.gz下载
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        //指定打开浏览器安装路径
        System.getProperty("webdriver.chrome.bin","F:\\IdeaProjects\\UIAutoTest2018\\src\\all_selenium\\chromedriver.exe");
        //创建一个webdriver实例
        WebDriver driver = new ChromeDriver();
        driver.get("https://pypi.python.org/pypi/selenium/2.35.0");
        Thread.sleep(3000);
        driver.findElement(By.xpath(".//*[@id='download-button']/a/span[text()='selenium-2.35.0.tar.gz']")).click();
    }
}