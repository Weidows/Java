package editor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 字体格式
class Format extends JDialog implements ActionListener {

  public static int style = 0; // 全局变量类型，默认值为0
  public static int size = 16; // 全局变量字体大小，默认值为16
  public static Font font = new Font("New song", style, size); // 全局变量字体，默认值为新宋体

  JPanel pn = new JPanel();
  JPanel okCelPn = new JPanel();
  JPanel fontPn = new JPanel();
  JPanel ptPn = new JPanel();
  JLabel fontLabel = new JLabel("Font: ");
  JLabel fontStyleLabel = new JLabel(" Font: ");
  JLabel ptLabel = new JLabel(" Pounds : ");
  JButton ok = new JButton("Yes");
  JButton cancel = new JButton("Cancel");
  GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();// 获取系统中可用的字体的名字
  String[] fontName = e.getAvailableFontFamilyNames();// 获取系统中可用的字体的名字
  String[] fontType = {"General", "Tilt", "Bold", "B&T"};
  JList fontList = new JList(fontName);
  JList fontTypeList = new JList(fontType);
  JScrollPane fontScroll = new JScrollPane(fontList);
  JScrollPane fontTypeScroll = new JScrollPane(fontTypeList);

  JTextArea textarea;
  SpinnerModel spinnerModel = new SpinnerNumberModel(size, // initial value
      0, // min
      100, // max
      2 // Step
  );
  JSpinner spinner = new JSpinner(spinnerModel);

  public Format(JTextArea textarea) {
    this.textarea = textarea;
    ok.addActionListener(this);
    cancel.addActionListener(this);

    pn.setLayout(new GridLayout(2, 1));
    pn.add(fontPn);
    pn.add(ptPn);

    fontPn.add(fontLabel);
    fontPn.add(fontScroll);
    fontPn.add(fontStyleLabel);
    fontPn.add(fontTypeScroll);

    ptPn.add(ptLabel);
    ptPn.add(spinner);

    fontList.setVisibleRowCount(5);
    fontList.setFixedCellWidth(60);
    fontList.setSelectedIndex(50);
    fontList.setSelectedValue(font.getFontName(), true);

    fontTypeList.setVisibleRowCount(5);
    fontTypeList.setSelectedIndex(style);
    okCelPn.add(ok);
    okCelPn.add(cancel);

    okCelPn.setLayout(new FlowLayout(FlowLayout.RIGHT));

    this.add(pn, BorderLayout.CENTER);
    this.add(okCelPn, BorderLayout.SOUTH);

    this.setTitle("Font");
    this.pack();
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == ok) {
      System.out.println(fontList.getSelectedValue());
      style = this.type();
      size = Integer.parseInt(spinner.getValue().toString());
      font = new Font((String) fontList.getSelectedValue(), style, size);
      textarea.setFont(font);
      this.dispose();
      System.out.println(type());
    } else if (e.getSource() == cancel) {
      this.dispose();
    }
  }

  private int type() {
    if (fontTypeList.getSelectedValue().equals("Tilt")) {
      return 1;
    } else if (fontTypeList.getSelectedValue().equals("Bold")) {
      return 2;
    } else if (fontTypeList.getSelectedValue().equals("B&T")) {
      return 3;
    } else {
      return 0;
    }
  }

}
