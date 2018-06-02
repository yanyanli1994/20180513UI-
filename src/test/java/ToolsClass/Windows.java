package ToolsClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2018-05-13.
 * selenium 多窗口切换（windows)工具类
 */
public class Windows {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:/chromedriver_win32/chromedriver.exe");
        ChromeOptions Options = new ChromeOptions();
        Options.addArguments("user-data-dir=C:\\Users\\happy\\AppData\\Local\\Google\\Chrome\\User Data");
        WebDriver driver = new ChromeDriver(Options);
        driver.manage().window().maximize();
        // 窗口最大化
        driver.get("http://www.sina.com.cn/");
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // 设置元素等待时间 ，隐式等待
        String sreachHand = driver.getWindowHandle();
        // 获取当前窗口的句柄
        driver.findElement(By.linkText("体育")).click();
        // 打开新浪官网上的体育链接
        driver.findElement(By.linkText("娱乐")).click();
        // 打开新浪官网上的娱乐链接
        java.util.Set<String> Handles = driver.getWindowHandles();
        System.out.println(Handles.size() + "集合长度");
        // 获取所有窗口的句柄并将句柄放在Set集合中。
        // 以下判断是否是新浪网首页，如果是则关闭新浪网首页。
        for (String i : Handles) {
            if (i.equals(sreachHand)) {
                driver.switchTo().window(i);
                Thread.sleep(5000);
                driver.close();

            }
        }
    }
}
