package Test20180408_Protice2;

import org.junit.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-04-16.
 */
public class ProcticeOnTestNg {
    @BeforeClass
   public void beforeClass(){
       System.out.println("beforeClass");
   }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest");
    }
    @Test
    public void aFastTest(){
        System.out.println("aFastTest");
    }
    @Test
    public void bSlowTest(){
        System.out.println("esbSlowTest");
    }
    @AfterTest
    public void afterTest()
    {
        System.out.println("afterTest");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("afterClass");
    }
}
