package cn.itscat.reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectTest {

    public static void main(String[] args) throws Exception {
        //创建properties对象
        Properties pro = new Properties();
        //获取这个字节码文件的类构造器
        ClassLoader classLoader = ReflectTest.class.getClassLoader();
        //通过这个构造器读取配置文件，并返回字符流
        InputStream is =classLoader.getResourceAsStream("pro.properties");
        //通过properties类的load方法获取到配置里面的内容
        pro.load(is);

        //获取配置文件中指定的值
        String className = pro.getProperty("className");
        String MotodeName = pro.getProperty("methodName");

        //加载配置文件了的class文件进内存
        Class cls =Class.forName(className);
        //创建类对象
        Object obj = cls.newInstance();
       ////传入配置文件里需要执行的方法名
        Method mothod1 = cls.getMethod(MotodeName);
        //执行方法
        mothod1.invoke(obj);


    }


}
