/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:39:13
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 11:19:27
 * @FilePath: \Weidows\Java\src\main\java\test\two\Shape.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.two;

public abstract class Shape {
  String shapeName;

  public Shape(String string) {
    this.shapeName = string;
  }

  abstract double area();

  @Override
  public String toString() {
    return shapeName;
  };
}
