/*
 * @Author: Weidows
 * @Date: 2020-09-10 16:46:16
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-10 17:05:14
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\anonymous_object\test.java
 */
package twenty.september.anonymous_object;

public class Test {
  int count = 0;

  public void test(int count) {
    System.out.println("这是个测试" + count);
  }

  public static void main(String[] args) {
    /**
     * 这里new了一个匿名对象,可以直接调用此对象的方法.
     * 如果一个对象只需要进行一次方法调用,可以使用匿名对象
     * 常使用匿名对象作为实参传递给一个方法调用
     */
    new Test().test(new Test().count);
  }
}