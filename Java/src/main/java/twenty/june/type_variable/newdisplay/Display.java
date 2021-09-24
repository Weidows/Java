/*
 * @Author: Weidows
 * @Date: 2020-06-20 18:18:06
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-28 09:36:38
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\type_variable\newdisplay\Display.java
 */
package twenty.june.type_variable.newdisplay;

import twenty.june.type_variable.newclock.Clock;

public class Display {
  private int value = 0;
  private int limit = 0;

  public Display(int limit) {
    this.limit = limit;
  }

  public void increase() {
    value++;
    if (value == limit) {
      value = 0;
    }
  }

  public int getvalue() {
    return value;
  }

  public static void main(String[] args) { /**main也是类函数 */
    Clock.step += 1;
    /**
     * 类变量不用创建对象也可以直接访问
     * 类变量属于类而非对象,所有对象共同读写这么一个变量
     * 如果是普通的成员变量的话,实例化后每个对象都有一个分别管理的此变量
     * 类方法使用形式改变: 类.方法()  而非对象.方法()
     */
    Clock.f(); /**类函数直接调用,用不到对象,但是需要指明类名 */
  }
}
