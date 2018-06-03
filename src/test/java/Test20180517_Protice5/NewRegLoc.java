package Test20180517_Protice5;

/**
 * Created by Administrator on 2018-06-03.
 */
public interface NewRegLoc {
    String accountname="//input[@id='regName']";
    String passwords="//input[@id='pwd']|//input[@id='pwdRepeat']";
    String submit="//input[@id='registersubmit']";


    String regsuc="//div[contains(text(),'%1$s 已注册成功')]";
}
