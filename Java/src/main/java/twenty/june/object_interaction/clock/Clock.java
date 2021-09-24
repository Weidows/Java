/*
 * @Author: Weidows
 * @Date: 2020-06-23 19:58:42
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:53:51
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\object_interaction\clock\Clock.java
 */
package twenty.june.object_interaction.clock;

/**在某个包下的所有.java源文件需要加上package 包名(单个源文件可以省略
 * 且包名首字母必须小写,首字母不能是数字,所有java项目文件路径只能用下划线) */

import twenty.june.object_interaction.display.Display;

public class Clock {
  private Display hour = new Display(24);
  private Display minute = new Display(60);

  /** 这种以对象为成员变量的需要new
   * private只能修饰类里面成员变量和成员函数,作用是使其在类外面无法访问
   * 如外面clock.hour就无法访问到,相反public可以访问和使用;
   * 如果没有写public或者private,那类型就是friendly,其只能在同一个包
   * (可以理解为一个文件夹目录下)里可以访问使用
   * 另外还有一种protected,在继承中会讲到
   */

  public void start() {
    while (true) { // 注意这个不能写成while(1),不对
      minute.increase();
      if (minute.getvalue() == 0) {
        hour.increase();
      }
      System.out.printf("%02d:%02d\n", hour.getvalue(), minute.getvalue());/** 这个神tm跟C语言一样 */
    }
  }
}
