package com.yyz;

/**
 * @author 一卓
 * @ClassName: sddf
 * @description: TODO
 * @date 2019/6/15 11:39
 */

public class sddf {
    static class Cat{
        int a=2;
        String str = "qwe";
    }
    public static void main(String[] args) {
        int a,b;
        a=1;
        b=1;
        Cat c =new Cat();
//        c.str="45";
        Cat d =new Cat();
//        c=d;
        System.out.println(a==b);
        System.out.println(c == d);
        System.out.println(c.equals(d));
        System.out.println(c.a==d.a);
        System.out.println(c.str.equals(d.str));
    }
}
