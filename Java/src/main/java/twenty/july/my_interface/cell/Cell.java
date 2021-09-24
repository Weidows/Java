/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-30 23:34:24
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\my_interface\cell\Cell.java
 */

package twenty.july.my_interface.cell;

import java.awt.Graphics;

public interface Cell {//注意这里不能写成interface class
  /**
   * *Cell是一个接口而非类(接口是一种完全抽象的抽象类)
   * !这个接口就是为了实现Fox和Rabbit类new的对象能够传递给Field类
   * Field类中指明需要的对象的类是Cell而Cell是作为中间承接者
   * Fox和Rabbit类需要有implements Cell语句来实现接口
   */
  /**
   * !注意这里函数可以不用写函数前缀,只需要写返回值类型
   * 抽象类无函数主体,只需声明函数原型,实现抽象类/接口的类都必须Override所有抽象方法,否则此子类仍为抽象类
   * abstract与final是冲突对立关系,抽象是用来被继承或重写的,final相反是不让继承/重写的
   */
  void draw(Graphics g, int x, int y, int size);
}
