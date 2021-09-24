/*
 * @Author: Weidows
 * @Date: 2020-07-20 14:31:09
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 14:25:22
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\animal\Fox.java
 */
package twenty.july.control_inversion.animal;

import java.awt.Graphics;

import java.awt.Color;
import java.util.ArrayList;

import twenty.july.control_inversion.cell.Cell;

public class Fox extends Animal implements Cell {
  public Fox() {
    super(20, 4);
  }

  @Override // 实现接口Cell中的draw()
  public void draw(Graphics g, int x, int y, int size) {
    int alpha = (int) ((1 - getAgePercent()) * 255);
    g.setColor(new Color(0, 0 , 0, alpha));
    g.fillRect(x, y, size, size);
  }

  @Override
  public Animal breed() {
    Animal ret = null;
    if (isBreedable() && Math.random() < 0.05) {
      ret = new Fox();
    }
    return ret;
  }

  @Override
  public String toString() {
    return ("Fox:" + super.toString());
  }

  @Override
  public Animal feed(ArrayList<Animal> neighbor) {
    Animal ret = null;
    if (Math.random() < 0.2) {
      ret = neighbor.get((int) (Math.random() * neighbor.size()));
      longerLife(2);
    }
    return ret;
  }
}