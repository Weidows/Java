/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 15:28:38
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-26 15:35:12
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo2.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

import java.lang.annotation.ElementType;

public class Demo2 {
  public static void main(String[] args) {
    Class c1 = Object.class; //类
    Class c2 = Runnable.class; //接口
    Class c3 = String[].class; //- -维数组
    Class c4 = int[][].class; //二维数组
    Class c5 = Override.class; //注解
    Class c6 = ElementType.class; //枚举
    Class c7 = Integer.class; //基本数据类型
    Class c8 = void.class; //void
    Class c9 = Class.class; //Class
    System.out.println(c1);//class java.lang.Object
    System.out.println(c2);//interface java.lang.Comparable
    System.out.println(c3);//class [Ljava.lang.String;
    System.out.println(c4);//class [[I
    System.out.println(c5);//interface java.lang.Override
    System.out.println(c6);//class java.lang.annotation.ElementType
    System.out.println(c7);//class java.lang.Integer
    System.out.println(c8);//void
    System.out.println(c9);//class java.lang.Class
  }
}
