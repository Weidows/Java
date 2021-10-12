/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:56:55
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 11:23:02
 * @FilePath: \Weidows\Java\src\main\java\test\two\Paint.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.two;

// Paint.java, represents a type of paint that has a fixed area covered by a litre

public class Paint {
  private double coverage; // number of square metres per litre

  // Constructor for the paint object
  public Paint(double c) {
    coverage = c;
  }

  // Returns the amount of paint (number of litres)
  // needed to paint the shape given as the parameter
  public double amount(Shape s) {
    System.out.println("Computing amount for " + s);
    return s.area() / coverage;
  }
}
