package Test20180330;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by lixx on 2018-03-18.D:\IdeaProjects\UIAutoTest\src\test\java\TestDemo.java
 */
public class TestDemo {
    @Test
    public void testcase1(){
        Assert.assertTrue(false);
        System.out.println("testcase1");
    }
    @Test
    public void testcase2(){
        Assert.assertTrue(true);
        System.out.println("testcase1");
    }
}
