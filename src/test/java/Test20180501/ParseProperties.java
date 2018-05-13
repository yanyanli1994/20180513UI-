package Test20180501;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Administrator on 2018-05-03.
 */
public class ParseProperties {
    private Properties pro = new Properties();

    public ParseProperties(String propertiespath){
        this.loadProperties(propertiespath);
    }
    private void loadProperties(String propertiespath){
        try {
            InputStream in = new FileInputStream(propertiespath);
            pro.load(in);
        } catch (IOException e) {
            //加载properties文件
            e.printStackTrace();
        }
    }
    public String getTestData(String keyname)
    {
        //获取properties文件中的特定value值
        return pro.getProperty(keyname).trim();
    }
}
