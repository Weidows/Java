/*
 * @Author: Weidows
 * @Date: 2020-07-20 18:49:07
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 17:40:09
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\my_interface\animal\Rabbit.java
 */
package twenty.july.my_interface.animal;

import java.awt.Color;
import java.awt.Graphics;

import twenty.july.my_interface.cell.Cell;

public class Rabbit extends Animal implements Cell {
  public Rabbit() {
    super(10, 2); // *寿命&&生育年龄
  }

  @Override
  public void draw(Graphics g, int x, int y, int size) {
    int alpha = (int) ((1 - getAgePercent()) * 255);
    g.setColor(new Color(255, 0, 0, alpha));
    g.fillRect(x, y, size, size);
  }

  @Override
  public Animal breed() {
    Animal ret = null;
    if (isBreedable() && Math.random() < 0.12) {
      ret = new Rabbit();
    }
    return ret;
  }

  @Override
  public String toString() {
    return "Rabbit" + super.toString();
  }
}