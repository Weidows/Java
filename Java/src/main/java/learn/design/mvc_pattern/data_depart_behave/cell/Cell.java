/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 17:47:34
 * @FilePath: \Weidows\Java\src\main\java\design\mvc_pattern\data_depart_behave\cell\Cell.java
 */

package learn.design.mvc_pattern.data_depart_behave.cell;

import java.awt.Graphics;//?图形库

public class Cell {
  private boolean ifAlive = false;

  public void die() {
    ifAlive = false;
  }

  public void reborn() {
    ifAlive = true;
  }

  public boolean isAlive() {
    return ifAlive;
  }

  public void draw(Graphics g, int x, int y, int size) {
    g.drawRect(x, y, size, size);
    if (ifAlive) {
      g.fillRect(x, y, size, size);
    }
  }
}
