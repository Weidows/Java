/*
 * @Author: Weidows
 * @Date: 2020-09-10 17:18:43
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 18:01:01
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\anonymous_object\Circle.java
 */
package twenty.september.anonymous_object;

public class Circle {
  private double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getArea() {
    double ret = 3.14 * radius * radius;
    return ret;
  }

  public static void main(String[] args) {
    /**
     * 可以同时使用构造器初始化类属性然后再调用方法
     */
    System.out.println(new Circle(5).getArea());
  }
}
