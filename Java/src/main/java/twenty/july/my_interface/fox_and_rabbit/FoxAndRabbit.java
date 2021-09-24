/*
 * @Author: Weidows
 * @Date: 2020-07-20 18:40:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-15 23:14:57
 * @FilePath: \Github\Weidows\Java\src\main\java\twenty\july\my_interface\fox_and_rabbit\FoxAndRabbit.java
 */
package twenty.july.my_interface.fox_and_rabbit;

import java.util.ArrayList;

import javax.swing.JFrame;

import twenty.july.my_interface.animal.Animal;
import twenty.july.my_interface.animal.Fox;
import twenty.july.my_interface.animal.Rabbit;
import twenty.july.my_interface.cell.Cell;
import twenty.july.my_interface.field.Field;
import twenty.july.my_interface.field.Location;
import twenty.july.my_interface.field.View;

public class FoxAndRabbit {
  private Field theField;
  private View theView;

  public FoxAndRabbit(int size) {
    theField = new Field(size, size);
    for (int row = 0; row < theField.getHeight(); row++) {
      for (int col = 0; col < theField.getWidth(); col++) {
        double probability = Math.random();
        if (probability < 0.05) {
          theField.place(row, col, new Fox());
        } else if (probability < 0.15) {
          theField.place(row, col, new Rabbit());
        }
      }
    }
    theView = new View(theField);
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setTitle("Cells");
    frame.add(theView);
    frame.pack();
    frame.setVisible(true);
  }

  public void start(int steps) {
    for (int i = 0; i < steps; i++) {
      step();
      theView.repaint();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void step() {
    for (int row = 0; row < theField.getHeight(); row++) {
      for (int col = 0; col < theField.getWidth(); col++) {
        Cell cell = (Cell) theField.get(row, col);
        if (cell != null) {
          Animal animal = (Animal) cell;
          animal.grow();
          if (animal.isAlive()) {
            // *move
            Location loc = animal.move(theField.getFreeNeighbor(row, col));
            if (loc != null)
              theField.move(row, col, loc);
            // *eat
            Cell[] neighbor = (Cell[]) theField.getNeighbor(row, col);
            ArrayList<Animal> listRabbit = new ArrayList<Animal>();
            for (Cell an : neighbor) {
              if (an instanceof Rabbit) {
                listRabbit.add((Rabbit) an);
              }
            }
            if (!listRabbit.isEmpty()) {
              Animal fed = animal.feed(listRabbit);
              if (fed != null)
                theField.remove((Cell) fed);
            }
            // *breed
            Animal baby = animal.breed();
            if (baby != null) {
              theField.placeRandomAdj(row, col, (Cell) baby);
            }
          } else {
            theField.remove(row, col);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    FoxAndRabbit fnr = new FoxAndRabbit(50);
    fnr.start(100);
  }
}