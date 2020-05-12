package cn.itscat.reflect;

import cn.itscat.domain.Person;


import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Field;
import java.util.function.ObjLongConsumer;

public class reflectdome02 {

    /**
     * 1、获取成员变量
     * 		Field[] getFields()  			// 获取所有用 public 修饰的成员变量   返回一个Field[]数组
     * 		Field getField(String name)  		// 获取指定的成员变量
     *
     * 		Field[] getDeclaredFields()  ;		// 获取成员变量   不考虑修饰符
     * 		Field getDeclaredField(String name)  ；   // 获取指定的成员变量，不考虑修饰符
     */
    public static void main(String[] args) throws Exception {
       //1、获取该类所有成员变量

        Class personclass = Person.class;   //获取该类的类对象
        Field[] personfield = personclass.getFields(); //获取该类对象下的所有成员变量，只能是public修饰的成员变量
        for (Field field:personfield){
            System.out.println(field);    //遍历打印
        }

        System.out.println("-------------------------------");
        //2、获取、修改指定成员的值

        Field pesfield = personclass.getField("A"); //获取指定成员变量 A
        Person pes = new Person();              //实例化Person对象
        Object vlaue = pesfield.get(pes);       //接收get方法返回的Object值
        System.out.println("A的值:"+vlaue);    //打印A的值

        pesfield.set(pes,"A被重新赋值");     //给A重新赋值
        System.out.println(pes);


        System.out.println("------------------------");
        System.out.println("以下是getDeclaredFields()方法--------->允许访问private等对象");
        //打印所有的成员变量，包括private的
        Field[] persongetdf = personclass.getDeclaredFields();
        for (Field ss : persongetdf){
            System.out.println(ss);
        }

        System.out.println("------------------------");

        Field pesfiled1 = personclass.getDeclaredField("name");
        pesfiled1.setAccessible(true);  //暴力反射，因为private对象不允许访问或修改，需要处理权限问题
        vlaue = pesfiled1.get(pes);     //获取该成员变量的值
        System.out.println("name的值："+vlaue);

        pesfiled1.set(pes,"GGH");       //修改该成员变量的值
        System.out.println(pes);

    }



}
