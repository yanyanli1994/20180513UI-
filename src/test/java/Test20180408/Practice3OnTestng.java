package Test20180408;

import org.testng.annotations.Test;

/**
 * Created by Administrator on 2018-05-22.
 * 与testsuite搭配使用
 */
public class Practice3OnTestng {
    @Test(groups = "submodule1")
    public void testSubModule1(){
        System.out.println("--testSubModule1--");
    }
    public void testSubModule2(){
        System.out.println("--testSubModule2--");
    }
    public void testSubModule3(){
        System.out.println("--testSubModule3--");
    }
}
