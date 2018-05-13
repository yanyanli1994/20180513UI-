package Test20180513;

import ToolsClass.Wait;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 2018-05-13.
 * 滚动条拖动
 */
public class DragAndDrop {
    @Test
    public void dragAndDrop(){
        FirefoxDriver ffwb = new FirefoxDriver();
        Wait wait = new Wait(ffwb);
        ffwb.get("http://yixun.com");
        ((JavascriptExecutor) ffwb).executeScript("window.scrollBy(0,6000)",  "");
         wait.waitFor(5000);
    }
}

