package Test20180517_Protice5;

import Test20180408_Protice2.TestData.ParseProperties;
import ToolsClass.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by Administrator on 2018-05-19.
 */
public class Do {
    private WebDriver driver;
    private ParseProperties locator=new ParseProperties(System.getProperty("user.dir")+"\\tool\\locators.properties");
    private Wait waiter;
    public Do(WebDriver driver){
        this.driver=driver;
        waiter=new Wait(driver);
    }
    public WebElement what(String locatorname){
        return driver.findElement(By.xpath(locator.getValue(locatorname)));
//        WebElement we = null;
//        try{
//            we=driver.findElement(By.xpath(locatorname));
//        }catch (NoSuchElementException e){
//            System.out.println("--------:(---------)");
//        }
//        return we;
    }
    public List<WebElement> whats(String locatorname){

        return driver.findElements(By.xpath(locatorname));
    }
    public void waitForeElementPresent(String locatorname){
        waiter.waitForElementPresent(locatorname);
    }
    public void waitForeElementIsEnable(String locatorname){
        waiter.waitForElementIsEnable(locatorname);
    }
    public WebElement whatCSS(String locatorname){
        WebElement we=null;
        try {
            we = driver.findElement(By.cssSelector(locatorname));
        }catch (NoSuchElementException e){
            System.out.println("-----:(---------)");
        }
        return we;
    }


    public void waitFor(long timeout){
        waiter.waitFor(timeout);
    }
}
