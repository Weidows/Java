/*
 * @Author: Weidows
 * @Date: 2020-10-19 18:28:02
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-19 22:22:47
 * @FilePath: \Weidows\Java\src\main\java\design\factory_method\Test.java
 */
package learn.design.factory_method;

public class Test {
  public static void main(String[] args) {
    /**
     * * 一般 类的构建A 与 程序流程布置B 的程序员分开
     *  这样把工作的分工就叫工厂模式,使得无论构建类的A怎么改类内部的东西,都不影响B
     */
    BWM b3 = new BWM3Factory().produceBWM();
    BWM b5 = new BWM5Factory().produceBWM();
    BWM b7 = new BWM7Factory().produceBWM();
  }
}
