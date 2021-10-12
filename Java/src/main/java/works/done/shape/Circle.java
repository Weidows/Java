/*
 * @Author: Weidows
 * @Date: 2020-11-04 18:47:05
 * @LastEditors: Weidows
 * @LastEditTime: 2021-01-17 17:14:03
 * @FilePath: \Weidows\Java\src\main\java\homework\done\shape\Circle.java
 * @Description:
 */
package works.done.shape;

public class Circle implements Shape {
  @Override
  public double area(double r) {
    return 3.14 * r * r;
  }
}
