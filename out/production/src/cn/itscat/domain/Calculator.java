package cn.itscat.domain;

public class Calculator {

    @Check
    public void add(){
        System.out.println("1 + 0 = "+ (1+0));
    }
    @Check
    public void sub(){
        System.out.println("1 - 0 ="+(1 - 0) );
    }
    @Check
    public void mul(){
        System.out.println("1 * 0 ="+ 1* 0);
    }
    @Check
    public void div(){
        System.out.println("1 / 0 =" + (1/0));
    }
    @Check
    public void show(){
        System.out.printf("永不bug。。。");
    }
}
