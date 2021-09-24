/*
 * @Author: Weidows
 * @Date: 2020-09-30 23:13:28
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-03 10:33:11
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\about_final\Final.java
 */
package twenty.september.about_final;

public final class Final {
  int age;
  String name;
  // final String DESCRIPTION; 报错
  final String DESCRIPTION = ""; //final修饰的变量是常量,必须显示赋值,且只能赋值一次
  final static String DESCRIPTION_1 = ""; //final static修饰的变量是全局常量
  //! 注意常量名一般使用全大写

  public final void test() {

  }
}

/* 
class Test extends Final {
  @Override
  public void test() {
    
  }
}
 */

/**
 * final修饰的类不能被继承,修饰的方法不能被重写
 */