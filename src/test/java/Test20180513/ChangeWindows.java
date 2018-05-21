package Test20180513;

import ToolsClass.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-13.
 * Windows的跳转
 */
public class ChangeWindows {
    @Test
    public void changeWindows(){
        FirefoxDriver ffwb = new FirefoxDriver();
        Wait wait = new Wait(ffwb);
        ffwb.get("http:www.google.com.hk");
        ffwb.findElement(By.xpath("//input[@name='q']")).sendKeys("selenium");
        ffwb.findElement(By.xpath("//input[@name='q']")).submit();
        ffwb.findElement(By.xpath("//a[contains(text(),'-Web Browser Automation')]")).click();
//        Switch switchW = new Switch(ffwb);
//        switchW.toSpecificWindow("Web Browser Automation");
        ffwb.findElement(By.xpath("//li[@id='menu_documentation']/a[text()='Documentation']")).click();
    }
}
