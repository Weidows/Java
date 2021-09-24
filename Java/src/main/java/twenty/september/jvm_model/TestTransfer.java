/*
 * @Author: Weidows
 * @Date: 2020-09-11 23:35:00
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-18 21:04:09
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jvm_model\TestTransfer.java
 */
package twenty.september.jvm_model;

public class TestTransfer {
  public static void swap(int a) {
    a = 6;
    System.out.println("in swap,a=" + a);
  }

  public static void main(String[] args) {
    int a=0;
    swap(a);
    System.out.println("in main,a=" + a);
  }
}
/**
 * 基本数据类型是把实参复制值到形参传入
 */