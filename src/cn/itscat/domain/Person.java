package cn.itscat.domain;

public class Person {

    private String name ;
    private int age ;

    public String A;
    public String C;
    String B;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", A='" + A + '\'' +
                '}';
    }

    public void eat(){
        System.out.println("eat...");
    }
    public void eat(String fool){
        System.out.println("eat..."+fool);
    }
    private void eat(String fool,int size){
        System.out.println("eat..."+size+fool);
    }
}
