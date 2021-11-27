/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:57:19
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 11:15:54
 * @FilePath: \Weidows\Java\src\main\java\test\two\PaintThings.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.two;

// PaintThings.java
// Computes the amount of paint needed to paint various things.
// Uses the amount method of the Paint class which takes any Shape as a parameter.

import java.text.DecimalFormat;

public class PaintThings {
  // Create some shapes and a Paint object
  // and print the amount of paint needed to paint each shape.

  public static void main(String[] args) {
    final double COVERAGE = 350;
    Paint paint = new Paint(COVERAGE);

    // Instantiate the two shapes to paint
    // Compute the amount of paint needed for each shape

    Sphere bigBall = new Sphere(15);
    Rectangle bigWall = new Rectangle(20, 35);

    double ballAmount = paint.amount(bigBall);
    double wallAmount = paint.amount(bigWall);

    // Print the amount of paint for each shape
    DecimalFormat fmt = new DecimalFormat("0.#");
    System.out.println("\nNumber of litres of paint needed...");
    System.out.println("Big Ball " + bigBall.toString() + " needs " + fmt.format(ballAmount) + " litres.");
    System.out.println("Big Wall " + bigWall.toString() + " needs " + fmt.format(wallAmount) + " litres.");
  }
}
