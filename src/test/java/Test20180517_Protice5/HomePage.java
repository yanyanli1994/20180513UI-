package Test20180517_Protice5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Administrator on 2018-05-19.
 */
public class HomePage {
    private WebDriver driver;
    @FindBy(xpath="//a[contains(text(),'免费注册')]")
    private WebElement reg;

    @FindBy(xpath="//a[(text(),'首页')]")
    private WebElement main;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void register(){
        reg.click();
    }
    public void navigateToJD(String url){
        driver.get(url);
    }
}
