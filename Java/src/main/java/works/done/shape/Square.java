/*
 * @Author: Weidows
 * @Date: 2020-11-04 18:46:27
 * @LastEditors: Weidows
 * @LastEditTime: 2021-01-17 17:13:45
 * @FilePath: \Weidows\Java\src\main\java\homework\done\shape\Square.java
 * @Description:
 */
package works.done.shape;

public class Square implements Shape {
  @Override
  public double area(double x) {
    return x * x;
  }
}
