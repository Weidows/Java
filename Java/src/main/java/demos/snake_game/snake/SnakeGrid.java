/*
 * @Author: Weidows
 * @Date: 2020-08-09 18:42:41
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-31 16:22:08
 * @FilePath: \Weidows\Java\src\main\java\demos\snake_game\snake\SnakeGrid.java
 */
package demos.snake_game.snake;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SnakeGrid extends JPanel {
  /**
   *
   */
  private static final long serialVersionUID = 3538364801699692123L;
  Food food = new Food();
  Snake snake = new Snake(food);//创建蛇
  ImageIcon image = new ImageIcon("./Java/image/SnakeGame/sky.jpg");//图片文件地址,与json大同小异,都是以工作区为root
  File f = new File("./Java/audio/SnakeGame/music.wav");//音乐文件地址
  SnakeThread snakeThread = new SnakeThread();

  SnakeGrid() {
    this.setBounds(0, 0, 700, 400);
    this.setBackground(Color.black);
    snakeThread.start();
    this.addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        snake.keyboard(e);
      }
    });
  }

  /**
   * 设置画笔
   * @param g
   */
  @Override
  public void paint(Graphics g) {
    super.paint(g);
    image.paintIcon(this, g, 0, 0); //设置背景图片
    snake.move();//蛇移动
    snake.draw(g);
    food.draw(g);
  }

  //读取音乐文件
  void Music() {
    try {
      URI uri = f.toURI();
      URL url = uri.toURL();
      AudioClip aau = Applet.newAudioClip(url);
      aau.loop();
    } catch (MalformedURLException e) {
      e.printStackTrace();
    }
  }

  class SnakeThread extends Thread {
    boolean flag = true;

    @Override
    public void run() {
      while (Snake.islive && flag) {
        try {
          Thread.sleep(300);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if (Snake.islive && Button.isMove) {
          repaint();
        }

      }
      if (!flag == false) {
        JOptionPane.showMessageDialog(SnakeGrid.this, "游戏结束");
      }

    }

    public void stopThread() {
      flag = false;
    }
  }
}
