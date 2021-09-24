package demos.snake_game.snake;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author Swyee
 */
public class Snake {
  public static final int span = 20;//间距
  public static final int rows = 20;//行
  public static final int cols = 35;//列
  public static final String up = "u";
  public static final String down = "d";
  public static final String left = "l";
  public static final String right = "r";
  public static boolean islive = true;
  Node body;//蛇的身体
  Node head;//蛇的头部
  Node tail;//蛇的头部
  Food food;

  Snake(Food food) {
    body = new Node(5, 20, left);
    head = body;
    tail = body;
    this.food = food;
  }

  class Node {
    int row;
    int col;
    String dir;//方向
    Node next;
    Node pre;

    Node(int row, int col, String dir) {
      this.row = row;
      this.col = col;
      this.dir = dir;
    }

    public void draw(Graphics g) {
      g.fillOval(col * span, row * span, span, span);//坐标

    }
  }

  /*
  把蛇画出来
   */
  public void draw(Graphics g) {
    g.setColor(Color.yellow);
    for (Node n = head; n != null; n = n.next) {
      n.draw(g);
      g.setColor(Color.green);
    }

  }

  /*
  调用键盘的上下左右键
  head.dir记录现在操作的是什么按钮，从而更改蛇的状态
  向上移送时，下键失效，其他四个方向也是如此判断
   */
  public void keyboard(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        if (head.dir.equals(down)) {
          break;
        }
        head.dir = up;
        break;
      case KeyEvent.VK_DOWN:
        if (head.dir.equals(up)) {
          break;
        }
        head.dir = down;
        break;
      case KeyEvent.VK_LEFT:
        if (head.dir.equals(right)) {
          break;
        }
        head.dir = left;
        break;
      case KeyEvent.VK_RIGHT:
        if (head.dir.equals(left)) {
          break;
        }
        head.dir = right;
        break;
      default:
        break;
    }
  }

  /*
  增加头部
   */
  public void addHead() {
    Node node = null;
    switch (head.dir) {
      case "l":
        node = new Node(head.row, head.col - 1, head.dir);
        break;
      case "r":
        node = new Node(head.row, head.col + 1, head.dir);
        break;
      case "u":
        node = new Node(head.row - 1, head.col, head.dir);
        break;
      case "d":
        node = new Node(head.row + 1, head.col, head.dir);
        break;
      default:
        break;
    }
    node.next = head;
    head.pre = node;
    head = node;

  }

  /*
  删除尾部
   */
  public void deleteTail() {
    tail.pre.next = null;
    tail = tail.pre;
  }

  /*
  增加move方法
   */
  public void move() {
    addHead();
    if (this.getSnakeRectangle().intersects(food.getCoordinates())) {//当蛇头与食物重合的时候 蛇吃食物 食物刷新，不再删除尾巴，达到一种蛇增长的要求

      food.repearShow();
    } else {
      deleteTail();
    }
    DeadOrLive();//每移动一步都要判断一下是否存活
  }

  public Rectangle getSnakeRectangle() {//获取蛇头的坐标

    return new Rectangle(head.col * span, head.row * span, span, span);

  }

  public void DeadOrLive() {//超出边框范围 蛇头撞到身体 游戏结束
    if (head.row < 0 || head.row > rows - 1 || head.col < 0 || head.col > cols) {
      islive = false;
    }
    for (Node n = head.next; n != null; n = n.next) {
      if (n.col == head.col && n.row == head.row) {
        islive = false;
      }
    }

  }
}
