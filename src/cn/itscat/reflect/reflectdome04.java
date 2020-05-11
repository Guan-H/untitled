package cn.itscat.reflect;

import cn.itscat.domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class reflectdome04 {

    /*3、获取成员方法
    Method[] getMethods()  		//用数组获取所有成员方法
    Method getMethod(String name, 类<?>... parameterTypes)  //获取指定的成员变方法

    Method[] getDeclaredMethods()
    Method getDeclaredMethod(String name, 类<?>... parameterTypes)

    区别: Method[] getMethods() 返回的是所有public修饰的方法,包括所有继承的public方法
          Method[] getDeclaredMethods() 返回包括公共，保护，默认（包）访问和私有方法，但不包括继承的方法

    */
    public static void main(String[] args) throws Exception {
       //1、获取该类所有成员方法

        Class personclass = Person.class;   //获取该类的类对象
        //获取指定方法名
        Method ps_method = personclass.getMethod("eat");
        //执行这个方法之前需要创建这个对象，作为参数传入invoke（）方法里
        Person ps = new Person();
        //执行方法
        ps_method.invoke(ps);

        //获取指定方法名（有参的）
        Method ps_method2 = personclass.getMethod("eat",String.class);
        //执行方法
        ps_method2.invoke(ps,"饭");

        System.out.println("-----------------------");

        //获取所有public修饰的成员方法  包括继承的public修饰的方法
        Method[] method = personclass.getMethods();
        for(Method method1 : method){
            System.out.println(method1);
            //method1.getname 获取成员方法名
            //String name = method1.getName();
            //System.out.println(name);
        }

        System.out.println("---------------------------------");

       //访问private修饰的的方法
        Method ps_method3 = personclass.getDeclaredMethod("eat",String.class,int.class);
        //因为访问的是privvate修饰的的方法，，所有需要执行setAccessslible方法 进行暴力反射
        ps_method3.setAccessible(true);
        ps_method3.invoke(ps,"碗",10);

        System.out.println("----------------------------------");

        //获取所有的 成员方法 包括private  但不包括继承的方法
        Method[] methods = personclass.getDeclaredMethods();
        for (Method method1 : methods){
            System.out.println(method1);
        }

    }

}
