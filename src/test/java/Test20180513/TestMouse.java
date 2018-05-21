//package Test20180513;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//
///**
// * Created by Administrator on 2018-05-13.
// * 对页面元素进行右击操作
// */
//public class TestMouse {
//    //参数:
//    //1.driver是我们的浏览器
//    //2.Actions是我们系统内置的执行鼠标一系列操作的对象
//    FirefoxDriver driver = new FirefoxDriver();
//    //鼠标左击:
//    Actions actions = new Actions(driver);
//    actions.click(这里传入我们需要点击的控件元素,WebElement类型).
//
//    perform();
//
//    //例如:
//    //找到我们慕课网首页登录的id
//    WebElement login = driver.findElement(By.id("js-signin-btn"));
//    //创建动作对象，并且指定操作的浏览器
//    Actions actions = new Actions(driver);
//    //单击操作传入参数，并且使用perform()提交,生效
//    actions.click(login).
//    perform();
//    //鼠标右击:
//    Actions actions = new Actions(driver);
//    actions.contextClick(这里传入我们需要点击的控件元素,WebElement类型).
//    perform();
//    //鼠标双击:鼠标双击的效果跟我们实际自己点击两次的效果有些出入，也不是那么智能
//    Actions actions = new Actions(driver);
//    actions.doubleClick(login).
//    perform();
//    //鼠标悬停:
//    Actions actions = new Actions(driver);
//    actions.moveToElement(这里传入我们需要点击的控件元素,WebElement类型).perform();
//
//}