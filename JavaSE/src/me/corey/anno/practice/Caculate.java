package me.corey.anno.practice;

/**
 * 待测试的类，其中实现了几个简单的待测试的方法
 */

public class Caculate {

    @TestErr
    public void plus() {
        System.out.println(1 + 0);
    }

    @TestErr
    public void minus() {
        System.out.println(1 - 1);
    }

    @TestErr
    public void multiply() {
        System.out.println(1 * 0);
    }

    @TestErr
    public void divide() {
        System.out.println(1 / 0);
    }

}
