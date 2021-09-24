package assignment.gui;

import javax.swing.*;

public class StudentListEditor {
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(StudentListEditor::createAndShowGUI);
  }

  private static void createAndShowGUI() {
    // 创建及设置窗口
    JFrame frame = new JFrame("StudentListEditor");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(600, 300, 500, 400);


    // 添加标签
    JLabel label = new JLabel("StudentListEditor");
    frame.getContentPane().add(label);

    // 显示窗口
    frame.pack();
    frame.setVisible(true);
  }
}
