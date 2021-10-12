/*
 * @Author: Weidows
 * @Date: 2020-07-25 18:49:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-16 20:10:07
 * @FilePath: \Weidows\Java\src\main\java\design\mvc_\kcb\KCB.java
 */
package learn.design.mvc_pattern.ke_cheng_biao;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * ! MVC设计模式:Model模型+View表现+Control控制
 * * 这里TableModel就是Model,JTable是View+Control
 */
public class KCB {
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    JTable table = new JTable(new KCBData());
    JScrollPane pane = new JScrollPane(table);
    frame.add(pane);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
