/*
 * @Author: Weidows
 * @Date: 2020-07-09 12:00:37
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:09:40
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\myabstract\Shape.java
 *
 *
 * 抽象类,抽象函数
 */
package twenty.july.myabstract;

import java.awt.Graphics;

public abstract class Shape {
  /**
   * *抽象函数不能有主体{},且只要有一个抽象函数,那这个类就是抽象类
   * !抽象类不能产生对象(这个类无法实体化),但是可以定义变量,
   * 作用是把这个抽象类的非抽象子类的对象赋给这个变量,比如:
   * *Shape s 这里s变量可以管理Shape所有非抽象子类的对象
   * !继承抽象类的所有子类必须覆盖(实现)父类中的抽象函数,否则子类必须是抽象类
   *
   * 两种抽象概念:
   *      1.与具体相对,表示抽象概念而非实体
   *      2.与细节相对,表示在一定程度上忽略细节着眼大体
   */
  public abstract void draw(Graphics g);//抽象函数
}
