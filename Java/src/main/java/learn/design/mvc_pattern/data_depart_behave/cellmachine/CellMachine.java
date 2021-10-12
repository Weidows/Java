/*
* @Author: Weidows
* @Date: 2020-07-12 11:52:59
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 17:48:49
 * @FilePath: \Weidows\Java\src\main\java\design\mvc_pattern\data_depart_behave\cellmachine\CellMachine.java
*/
package learn.design.mvc_pattern.data_depart_behave.cellmachine;

import javax.swing.JFrame;

import learn.design.mvc_pattern.data_depart_behave.cell.Cell;
import learn.design.mvc_pattern.data_depart_behave.field.Field;
import learn.design.mvc_pattern.data_depart_behave.field.View;

public class CellMachine {
  public static void main(String[] args) {
    // *新建一个棋盘
    Field field = new Field(30, 30);
    // *遍历棋盘,每个格子new Cell对象
    for (int row = 0; row < field.getHeight(); row++) {
      for (int col = 0; col < field.getWidth(); col++) {
        //在field每个格子上new Cell对象
        field.place(row, col, new Cell());
      }
    }
    for (int row = 0; row < field.getHeight(); row++) {
      for (int col = 0; col < field.getWidth(); col++) {
        // *接收上一步new的对象,并做判断执行
        Cell cell = field.get(row, col);
        if (Math.random() < 0.2) {
          cell.reborn();
        }
      }
    }
    View view = new View(field);
    JFrame frame = new JFrame();// !图形化窗口
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// *可关闭窗口
    frame.setResizable(false); // *不可更改窗口大小
    frame.setTitle("Cells"); // *窗口标题
    frame.add(view); //frame加入view
    frame.pack(); //自己决定大小
    frame.setVisible(true); // !可视化

    for (int i = 0; i < 1000; i++) {
      for (int row = 0; row < field.getHeight(); row++) {
        for (int col = 0; col < field.getWidth(); col++) {
          Cell cell = field.get(row, col);
          Cell[] neighbor = field.getNeighbor(row, col);
          int numOfLive = 0;
          for (Cell c : neighbor) {
            if (c.isAlive()) {
              numOfLive++;
            }
          }
          System.out.print("[" + row + "][" + col + "]:");
          //?学着点,单句判断指令
          System.out.print(cell.isAlive() ? "live" : "dead");
          System.out.print(":" + numOfLive + "-->");
          if (cell.isAlive()) {
            if (numOfLive < 2 || numOfLive > 3) {
              cell.die();
              System.out.print("die");
            }
          } else if (numOfLive == 3) {
            cell.reborn();
            System.out.print("reborn");
          }
          System.out.println();
        }
      }
      System.out.println("UPDATE");
      frame.repaint();
      try {
        Thread.sleep(200);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
