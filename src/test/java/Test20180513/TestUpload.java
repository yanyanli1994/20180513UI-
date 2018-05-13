package Test20180513;

import ToolsClass.Wait;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Administrator on 2018-05-13.
 * 上传文件
 */
public class TestUpload {
    @Test
    public void upload(){
        FirefoxDriver ffwb = new FirefoxDriver();
        Wait wait = new Wait(ffwb);
        du.what("sendbox").click();
        du.what("attachment").sendKeys("c:\\terry.txt");
        du.waitFor(5000);
    }
}
