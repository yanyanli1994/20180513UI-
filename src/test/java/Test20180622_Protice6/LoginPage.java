package Test20180622_Protice6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@id='idInput']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='pwdInput']")
	private WebElement passwd;
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	private WebElement login;
	
	
	
	public LoginPage(WebDriver driver){
		this.driver = driver;			
		PageFactory.initElements(driver, this);
	}
	
	public void navigate(String url){
		this.driver.get(url);
	}
	
	public void setUserName(String username){
		this.username.sendKeys(username);
	}
	
	public void setPassWord(String passwd){
		this.passwd.sendKeys(passwd);
	}
	
	public void login(){
		this.login.click();
	}
	
	
	
	
	
}
