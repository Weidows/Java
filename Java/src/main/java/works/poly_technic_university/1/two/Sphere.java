/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:41:31
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 10:58:23
 * @FilePath: \Weidows\Java\src\main\java\test\two\Sphere.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.two;

public class Sphere extends Shape {
  private double radius; // radius in metres

  // Constructor for the sphere
  public Sphere(double r) {
    super("Sphere");
    radius = r;
  }

  // Returns the surface area of the sphere
  public double area() {
    return 4 * Math.PI * radius * radius;
  }

  // Returns a String representation of the sphere
  public String toString() {
    return super.toString() + " of radius " + radius;
  }
}
