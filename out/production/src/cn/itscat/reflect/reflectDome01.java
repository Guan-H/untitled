package cn.itscat.reflect;

import cn.itscat.domain.Person;
import cn.itscat.domain.Student;

import static java.lang.Class.forName;

public class reflectDome01 {

    /*
    获取class对象的方式
	1、Class.forName("全类名");  //用class类接受返回的值
		*多用于配置文件，将类名定义在配置文件中，通过读取文件，加载类
	2、类名.class();    //用class接收返回的值
		*多同于参数传递
	3、对象.getClass();  //用class类接收返回的值
		*多用于对象获取字节码的方式
    */
    public static void main(String[] args) throws Exception {
        //通过Class.forName("全类名"); 获取类对象
        Class cls = Class.forName("cn.itscat.domain.Person");
        System.out.println(cls);

        //通过 类名.class 获取类对象
        Class cla1 = Person.class;
        System.out.println(cla1);

        //通过 对象.getclass()  获取类对象
        Person p = new Person();
        Class cla2 = p.getClass();
        System.out.println(cla2);

        //判断这三个是否是同一个类对象
        System.out.println(cls == cla1);
        System.out.println(cls == cla2);

        //不同的类所在的内存地址不一样，说明不是同一个类
        Student s = new Student();
        Class cla3 = s.getClass();
        System.out.println(cls == cla3);

    }
}
