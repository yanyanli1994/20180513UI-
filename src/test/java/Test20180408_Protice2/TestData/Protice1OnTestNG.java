package Test20180408_Protice2.TestData;


import org.junit.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-24.
 */
public class Protice1OnTestNG {
    @Parameters({"TestData"})
    @Test
    public void test(@Optional("aaa") String testdata){
        ParseProperties pp = new ParseProperties(System.getProperty("user.dir")+testdata);
        System.out.println(pp.getValue("url"));
        System.out.println(pp.getValue("username"));
        System.out.println(pp.getValue("password"));
        Assert.assertEquals("q".equals("q"),true);
    }

}
