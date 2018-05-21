package me.corey.permission;


public class Employee {

    public Employee(){
        System.out.println("father empty");
    }


    /**
     * 若没有定义任何构造函数，则默认会生成一个无参数的空构造函数，并且在构造函数第一行会调用super
     * 若定义了任何一个构造函数，则不会再自动生成无参数的构造函数
     * 子类构造函数第一行如果没有显示调用super，则都会默认去调用父类的无参构造函数，因此如果父类没有无参构造函数，则子类的构造函数都必须在第一行显示调用super(xxx),否则编译器会报错
     * @param s
     */
    public Employee(String s){
        System.out.println("father");
    }

    protected float salary;

    protected void sayHi(){
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void sayHello(){
        System.out.println(tag);
    }

    private static final String tag = "1";

    protected String getTag(){
        return tag;
    }


}
