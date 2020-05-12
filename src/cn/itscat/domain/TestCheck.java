package cn.itscat.domain;

import com.sun.org.apache.xpath.internal.operations.String;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestCheck {

    public static void main(String[] args) throws Exception {

        //1、创建需要测试的话对象Calculator
        Calculator c = new Calculator();

        //2、获取字节码文件
        Class cls = c.getClass();

        //3、获取类里的方法
        Method[] methods = cls.getMethods();
        //记录出现bug次数
        int number = 0;
        //
        BufferedWriter buffer = new BufferedWriter(new FileWriter("bug.txt"));
        for(Method method : methods){
            //4、判断方法是否有注解
            if(method.isAnnotationPresent(Check.class)){
                //5、如果有则执行
                try {
                    method.invoke(c);
                } catch (Exception e) {
                    //6、有问题的方法则记录
                    //记录出现问题的次数
                    number ++;
                    //记录出现异常的方法
                    buffer.write(method.getName()+"方法出现了异常");
                    buffer.newLine();
                    //记录出现异常名称
                    buffer.write("异常名称："+e.getCause().getClass().getSimpleName());
                    buffer.newLine();
                    //记录异常的原因
                    buffer.write("异常的原因"+e.getMessage());
                    buffer.newLine();

                    buffer.write("---------------------------------");
                    buffer.newLine();

                }
            }

        }
        buffer.write("总共出现了"+number+"次异常");
        buffer.flush();
        buffer.close();

    }



}
