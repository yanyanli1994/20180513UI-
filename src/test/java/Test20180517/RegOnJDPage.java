package Test20180517;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Administrator on 2018-05-20.
 */
public class RegOnJDPage {
    private WebDriver driver;
    private WebElement usernid;

    @FindBys(@FindBy(xpath = "//input[@id='pwd']|//input[@id='pwdRepeat']"))
    private List<WebElement> password;

    @FindBy(xpath = "//input[@id='registersubmit']")
    private WebElement regBtn;

    @FindBy(xpath = "//div[contain(text(),'we@1236.com')]")
    private WebElement regAccount;

    public RegOnJDPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void serUserId(String userid){
        usernid.sendKeys(userid);
    }
    public void setPassword(String password){
        for (WebElement we : this.password)
            we.sendKeys(password);
    }
    public void register(){
        regBtn.click();
    }

    public WebElement getRegistedUser(){
        return regAccount;
    }

}
