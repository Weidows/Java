package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class FindAndReplace extends JDialog implements ActionListener {// 查找和替换
  JLabel findLabel = new JLabel("FindRep：");
  JLabel repLabel = new JLabel(" Rep：");
  JTextField findTf = new JTextField(8);
  JTextField repTf = new JTextField(8);
  JButton findBtn = new JButton("Search");
  JButton repBtn = new JButton("Rep");
  JPanel findPn = new JPanel();
  JPanel repPn = new JPanel();
  JTextArea textarea;

  String text;
  boolean flg = false;
  int len;
  int start = 0;
  int k = 0;

  public FindAndReplace(JTextArea textarea) {

    this.textarea = textarea;

    findPn.add(findLabel);
    findPn.add(findTf);
    findPn.add(findBtn);
    repPn.add(repLabel);
    repPn.add(repTf);
    repPn.add(repBtn);
    this.add(findPn);
    this.add(repPn);

    findBtn.addActionListener(this);
    repBtn.addActionListener(this);

    this.setTitle("Search and Replace");
    this.setLayout(new GridLayout(2, 1));
    // this.setBounds(400, 200, 300, 140);
    this.pack();
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
    this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
  }

  @SuppressWarnings("deprecation")
  public void actionPerformed(ActionEvent e) {
    String findText = findTf.getText();
    String repText = repTf.getText();
    text = textarea.getText();
    if (e.getSource() == findBtn) {
      findBtn.setLabel("Next");
      if (findText != null) {
        len = findText.length();
        start = text.indexOf(findText, k);
        k = start + len;
        textarea.select(start, start + len);
        flg = true;
        if (start == -1) {
          JOptionPane.showMessageDialog(null, "The end", "Note", JOptionPane.INFORMATION_MESSAGE);
          start = 0;
          k = 0;
          flg = false;
        }
      }
    } else if (e.getSource() == repBtn) {
      if (flg) {
        textarea.replaceRange(repText, start, start + len);
        flg = false;
      }
    }
  }
}
