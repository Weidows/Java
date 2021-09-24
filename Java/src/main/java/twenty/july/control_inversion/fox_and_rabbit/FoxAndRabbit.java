/*
 * @Author: Weidows
 * @Date: 2020-07-20 18:40:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-16 08:58:13
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\fox_and_rabbit\FoxAndRabbit.java
 */
package twenty.july.control_inversion.fox_and_rabbit;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

import twenty.july.control_inversion.animal.Animal;
import twenty.july.control_inversion.animal.Fox;
import twenty.july.control_inversion.animal.Rabbit;
import twenty.july.control_inversion.cell.Cell;
import twenty.july.control_inversion.field.Field;
import twenty.july.control_inversion.field.Location;
import twenty.july.control_inversion.field.View;

public class FoxAndRabbit {
  private Field theField;
  private View theView;
  private JFrame frame;

  public FoxAndRabbit(int size) {
    theField = new Field(size, size);
    for (int row = 0; row < theField.getHeight(); row++) {
      for (int col = 0; col < theField.getWidth(); col++) {
        double probability = Math.random();
        if (probability < 0.05)
          theField.place(row, col, new Fox());
        else if (probability < 0.15)
          theField.place(row, col, new Rabbit());
      }
    }
    theView = new View(theField);
    frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setTitle("Cells");
    frame.add(theView);
    JButton btnStep = new JButton("单步");
    frame.add(btnStep, BorderLayout.NORTH);
    class StepListener implements ActionListener {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("按下了");
        step();
        frame.repaint();
      }
    }
    StepListener stepListener = new StepListener();
    btnStep.addActionListener(stepListener);
    /**
     * 这里实际上是做了个 内部 匿名 类(此处是函数内部类,只能访问函数内final变量)
     * *其作用相当于上面的那个类
     * *都是实现了interface ActionListener,Override了ActionPerformed()
     * *addActionListener(参数都是ActionListener new 的对象)
     * *只不过上面写的内部类StepListener有个名字而已
     * !这种匿名类implements实现的是interface接口,也可以继承为子类
     * Swing消息机制广泛使用匿名类(因大量使用新类,不用为新类起名字了)
    btnStep.addActionListener( new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("按下了");
        step();
        frame.repaint();
      }
    });
    */
    frame.pack();
    frame.setVisible(true);
  }

  public void start(int steps) {
    for (int i = 0; i < steps; i++) {
      step();
      theView.repaint();
      try {
        Thread.sleep(400);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }

  public void step() {
    for (int row = 0; row < theField.getHeight(); row++) {
      for (int col = 0; col < theField.getWidth(); col++) {
        Cell cell = theField.get(row, col);
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
