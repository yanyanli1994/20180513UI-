package Test20180408_Protice2.TestData;

import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 2018-05-24.
 */
public class ParseProperties {
    private Properties pro =new Properties();
    String value = null;

    public ParseProperties(String propertiespath)
    {
        this.loadProperties(propertiespath);
    }
    private void loadProperties(String propertiespath){
        try{
            InputStream in = new FileInputStream(propertiespath);
            InputStreamReader inr=new InputStreamReader(in);
            BufferedReader br =new BufferedReader(inr);
            pro.load(br);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getValue(String keyname){
        value=pro.getProperty(keyname).trim();
        try{
            value=new String(value.getBytes("UTF-8"),"UTF-8");
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {
        ParseProperties a =new ParseProperties("F:\\IdeaProjects\\UIAutoTest2018\\src\\test\\java\\Test20180408_Protice2\\TestData\\test.properties");
        System.out.println(a.getValue("password"));
    }
}
