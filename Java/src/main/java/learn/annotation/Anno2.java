/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 10:39:26
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-26 10:41:22
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\annotation\Anno2.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.annotation;

import java.lang.annotation.*;

@MyAnnotation
public class Anno2 {
  @MyAnnotation
  void test() {
  }
}

//Target 表示我们的注解可以用在哪些地方.
@Target(value = { ElementType.METHOD, ElementType.TYPE })

//Retention表示我们的注解在什么地方还有效。runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)

//Documented表示是否将我们的注解生成在Javadoc中
@Documented

//Inherited子类可以继承父类的注解
@Inherited

@interface MyAnnotation {
}
