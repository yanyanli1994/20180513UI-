package Test20180517;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Administrator on 2018-05-20.
 */
public class NewHomePage {
    private WebDriver driver;
    private Do du;
    public NewHomePage(WebDriver driver){
        this.driver=driver;
        du=new Do(driver);
    }

    public NewHomePage navigateToJD(String url){
        driver.get(url);
        return this;
    }

    public void register(){
        du.what(HomeLoc.reg).click();
    }
}
