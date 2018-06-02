package ToolsClass;

import org.openqa.selenium.WebDriver;

import java.util.Set;

/**
 * Created by Administrator on 2018-06-02.
 * 浏览器打开多个窗口并进行切换工具类
 */
public class Switch {
    private WebDriver driver;
    private String currentwindow;

    public Switch(WebDriver driver){
        currentwindow=driver.getWindowHandle();
    }

    public void toSpecificWindow(String partialTitleName){
        Set<String> handles=driver.getWindowHandles();
        String titlename;
        for (String handle:handles){
            titlename=driver.switchTo().window(handle).getTitle();
            if (titlename.contains(partialTitleName))
                break;
        }
    }

    public void backToCurrentWindow(){
        driver.switchTo().window(currentwindow);
    }
}
