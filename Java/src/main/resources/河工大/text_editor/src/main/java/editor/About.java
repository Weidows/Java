package editor;

import javax.swing.*;

class About extends JDialog {// 关于窗口

  About() {
    JOptionPane.showMessageDialog(null, " author：Hayley Yin and Jessica Feng\n email：3078625626@qq.com or 2296359313@qq.com\n", "About",
        JOptionPane.PLAIN_MESSAGE);
  }
}
