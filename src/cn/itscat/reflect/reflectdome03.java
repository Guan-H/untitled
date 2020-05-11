package cn.itscat.reflect;

import cn.itscat.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class reflectdome03 {


    public static void main(String[] args) throws Exception {
       //1、获取该类所有构造方法

        Class personclass = Person.class;   //获取该类的类对象

        //用Constructon构造器获取空参构造方法
        Constructor personcom=personclass.getConstructor();
        System.out.println(personcom);


        //获取有参构造方法   Constructor<?>[] getConstructors()
        Constructor personcom1 = personclass.getConstructor(String.class,int.class);
        //通过Class类里面的newInstance创建对象并初始化内容
        Object personc = personcom1.newInstance("张三",22);
        System.out.println(personc);

    }

}
