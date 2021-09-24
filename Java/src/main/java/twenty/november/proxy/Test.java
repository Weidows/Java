/*
 * @Author: Weidows
 * @Date: 2020-11-02 23:09:22
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-02 23:15:49
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\proxy\Test.java
 * @Description:
 */
package twenty.november.proxy;

public class Test implements TestInterface {

  @Override
  public void test_1() {
    System.out.println("Running in Test.test_1");
  }

  @Override
  public void test_2() {
    System.out.println("Running in Test.test_2");
  }

}
