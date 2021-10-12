/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 10:46:59
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:01:47
 * @FilePath: \Java\Java\src\main\java\learn\annotation\Anno3.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.annotation;

import java.lang.annotation.*;

public class Anno3 {

  public static void main(String[] args) {
  }

  //注解可以显示赋值，如果没有默认值 ，我们就必须给注解赋值
  @MyAnnotation2(name = {"Weidows", "齐下无贰"}, age = 21)
  public void test() {
  }

  @MyAnnotation3("Weidows") //参数只有一个，且参数名为value
  public void test1() {
  }
}

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2 {
  //注解的参数:参数类型+参数名();
  String[] name() default {""};

  int age() default 0;

  int id() default -1; // 如果默认值为-1,代表不存在。

  String schools() default "家里蹲大学";
}

/**
 * @Target(value = { ElementType.TYPE, ElementType.METHOD })
 * 只有一个参数时可以省略参数名,多个参数时不可省略
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3 {
  //只有一个参数时，参数名为value时，使用时不需参数名
  String value();
}
