package twenty.july.typesystem;

/*
 * @Author: Weidows
 * @Date: 2020-07-06 18:55:16
 * @LastEditors: Weidows
 * @LastEditTime: 2020-12-18 22:54:45
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\typesystem\Type.java
 */

public class Type {
  @Override //这个标记表示下面这个函数要覆盖父类的函数,且函数原型必须相同
  public String toString() {
    return "";
  }

  public static void main(String[] args) {
  }
}

/**
 * Java中Object类是所有类的父类(其他oop语言也是类似,除了C++)
 * 目前用到的toString()函数就是从Object类继承的,还有.equals()也是
 *      toString()默认返回传入对象的目录+@内存地址
 *      .equals()是对比这两个是否管理同一个对象
 *      在类中重定义来改变这两个函数的功能
 * 对象在造型之后其目标类型内的成员函数也可以调用
 */
