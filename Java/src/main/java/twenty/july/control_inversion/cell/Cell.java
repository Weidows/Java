/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-24 19:25:32
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\cell\Cell.java
 */

package twenty.july.control_inversion.cell;

import java.awt.Graphics;

public interface Cell {// 注意这里不能写成interface class
  /**
   * *Cell是一个接口而非类 !这个接口就是为了实现Fox和Rabbit类new的对象能够传递给Field类
   * Field类中指明需要的对象的类是Cell而Cell是作为中间承接者
   * Fox和Rabbit类需要有implements Cell语句来实现接口
   */
  /**
   * !注意这里函数不用写函数前缀,只需要写返回值类型
   * 抽象类无函数主体,只需声明函数原型,实现接口的类都必须Override
   */
  void draw(Graphics g, int x, int y, int size);
}
