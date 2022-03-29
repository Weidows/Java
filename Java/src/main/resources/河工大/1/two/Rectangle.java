/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:58:09
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 17:08:31
 * @FilePath: \Weidows\Java\src\main\java\homework\done\test\two\Rectangle.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.two;

public class Rectangle extends Shape {
  double height;
  double width;

  public Rectangle(double height, double width) {
    super("Rectangle");
    this.height = height;
    this.width = width;
  }

  @Override
  double area() {
    return height * width;
  }

  // Returns a String representation of the sphere
  public String toString() {
    return super.toString() + " of height " + height + ", and width " + width;
  }
}
