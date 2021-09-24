/*
 * @Author: Weidows
 * @Date: 2020-08-09 18:42:41
 * @LastEditors: Weidows
 * @LastEditTime: 2020-08-09 19:20:10
 * @FilePath: \Weidows\Java\src\main\java\demos\snake_game\snake\Button.java
 */
package demos.snake_game.snake;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Button extends JPanel {
  /**
   *
   */
  private static final long serialVersionUID = 83264962626272133L;
  public static boolean isMove = true;//表示运行状态 
  SnakeGrid snakeGrid;

  Button(SnakeGrid snakeGrid) {
    this.snakeGrid = snakeGrid;
    this.setBounds(0, 400, 700, 100);
    JButton jb1 = new JButton("暂停游戏");
    JButton jb2 = new JButton("继续游戏");
    JButton jb3 = new JButton("重新游戏");
    this.add(jb1);
    this.add(jb2);
    this.add(jb3);

    jb1.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        isMove = false;
      }
    });

    jb2.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        isMove = true;
        snakeGrid.setFocusable(true);
        snakeGrid.requestFocus();
      }
    });
    jb3.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {//重新创建蛇等 重新开始游戏
        snakeGrid.snakeThread.stopThread();

        Food food = new Food();
        snakeGrid.food = food;
        snakeGrid.snake = new Snake(food);
        Snake.islive = true;
        isMove = true;
        SnakeGrid.SnakeThread st = snakeGrid.new SnakeThread();
        snakeGrid.snakeThread = st;
        st.start();

        snakeGrid.setFocusable(true);
        snakeGrid.requestFocus();
      }
    });

  }
}
