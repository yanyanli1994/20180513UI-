package Test20180517;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Administrator on 2018-05-19.
 */
public class RegOnJD {
    private WebDriver driver;
    //账户名
    @FindBy(xpath="//input[@id='regName']")
    private WebElement usernid;
    //设置密码和请确人密码
    @FindBys(@FindBy(xpath="//input[@id='pwd']|//input[@id='pwdRepeat']"))
    private List<WebElement> password;
    //立即注册按钮
    @FindBy(xpath="//input[@id='registsubmit']")
    private WebElement regBtn;

    public RegOnJD(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setUserId(String userid){
        usernid.sendKeys(userid);
    }

    public void setPassword(String password){
        driver.findElements(By.xpath("xxx"));
        for(WebElement we:this.password){
            we.sendKeys(password);

        }
    }
}
