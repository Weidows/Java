/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:00
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 14:15:51
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\field\View.java
 */
package twenty.july.control_inversion.field;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import twenty.july.control_inversion.cell.Cell;

public class View extends JPanel {
  private static final long serialVersionUID = -2417015700213488315L;
  private static final int GRID_SIZE = 16;
  private Field theField;

  public View(Field field) {
    theField = field;
  }

  @Override
  public void paint(Graphics g) {
    super.paint(g);
    g.setColor(Color.GRAY);
    for (int row = 0; row < theField.getWidth(); row++) {
      for (int col = 0; col < theField.getHeight(); col++) {
        g.drawLine(0, row * GRID_SIZE, theField.getWidth() * GRID_SIZE, row * GRID_SIZE);
        g.drawLine(col * GRID_SIZE, 0, col * GRID_SIZE, theField.getHeight() * GRID_SIZE);
        Cell cell = theField.get(row, col);
        if (cell != null)
          cell.draw(g, row * GRID_SIZE, col * GRID_SIZE, GRID_SIZE);
      }
    }
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(theField.getWidth() * GRID_SIZE + 1, theField.getHeight() * GRID_SIZE + 1);
  }
}