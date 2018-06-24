package Test20180622_Protice6.testng_report;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class case1 {

    WebDriver driver;

    @Test
    public void Open() throws InterruptedException {

        System.getProperty("webdriver.chrome.bin","F:\\IdeaProjects\\UIAutoTest2018\\src\\all_selenium\\chromedriver.exe");
        //创建一个webdriver实例
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("testerhome");

    }


    @Test
    public void Open4() throws InterruptedException {

        System.setProperty("webdriver.firefox.bin","F:\\IdeaProjects\\UIAutoTest2018\\src\\all_selenium\\geckodriver.exe");

        FirefoxProfile fp = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(fp);
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("testerhome");
        Reporter.log("测试1通过");

    }


    @Test
    public void Open1() throws InterruptedException {

        System.setProperty("webdriver.friefox.bin","C:\\Program Files\\Mozilla Firefox\\firefox.exe");

        FirefoxProfile fp = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(fp);
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("testerhome");
        Reporter.log("测试2通过");

    }


    @Test
    public void Open2() throws InterruptedException {

        System.setProperty("webdriver.friefox.bin","C:\\Program Files\\Mozilla Firefox\\friefox.exe");

        FirefoxProfile fp = new FirefoxProfile();
        WebDriver driver = new FirefoxDriver(fp);
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("k1w")).sendKeys("testerhome");
        Reporter.log("测试3通过");

    }

    @AfterClass
    public void quit() throws InterruptedException {

        driver.quit();

    }

}