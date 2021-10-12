/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 10:23:03
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-26 10:24:15
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\annotation\Anno1.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.annotation;

public class Anno1 {

  @Override //重写方法
  public String toString() {
    return super.toString();
  }

  @Deprecated //表示弃用方法,但仍可使用
  public static void test() {
  }

  @SuppressWarnings("all") //抑制警告
  public static void test01() {
    int age;
  }

  public static void main(String[] args) {
    test();
    test01();
  }
}
