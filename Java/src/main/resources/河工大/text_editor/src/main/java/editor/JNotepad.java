package editor;

import org.yaml.snakeyaml.Yaml;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

/**
 * @author 3078525626@qq.com and 2296359313@qq.com
 * @created 2021年10月
 */
public class JNotepad extends JFrame implements ActionListener {

  JMenuBar menubar = new JMenuBar();
  JMenu file = new JMenu("File(F)");
  JMenu edit = new JMenu("Edit(E)");
  JMenu format = new JMenu("Layout(O)");
  JMenu help = new JMenu("Help(H)");
  JMenuItem create = new JMenuItem("New");
  JMenuItem open = new JMenuItem("Open...");
  JMenuItem save = new JMenuItem("Save");
  JMenuItem saveAs = new JMenuItem("Save as...");
  JMenuItem exit = new JMenuItem("Exit");
  JMenuItem undo = new JMenuItem("Undo");
  JMenuItem cut = new JMenuItem("Cut");
  JMenuItem copy = new JMenuItem("Copy");
  JMenuItem paste = new JMenuItem("Paste");
  JMenuItem findRep = new JMenuItem("Search");
  JMenuItem selectAll = new JMenuItem("All");
  JMenuItem time = new JMenuItem("Time");
  JMenuItem font = new JMenuItem("Font");
  JMenuItem about = new JMenuItem("About");
  JMenuItem cut2 = new JMenuItem("Cut(X)");

  JMenuItem copy2 = new JMenuItem("Copy(C)");
  JMenuItem paste2 = new JMenuItem("Paste(V)");
  JMenuItem selectAll2 = new JMenuItem("All(A)");
  public static JTextArea textarea = new JTextArea();
  UndoManager um = new UndoManager();
  JScrollPane scroll = new JScrollPane(textarea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  JPopupMenu popup = new JPopupMenu();
  String pathSelect;

  // 获取屏幕尺寸
  Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

  public JNotepad() {
    //加载配置
    Map<String, Map> settings = null;
    try {
      settings = new Yaml().loadAs(new FileInputStream(new File("src/main/resources/settings.yml")), Map.class);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

    // 此处定义键盘快捷键
    // MenuBar
    file.setMnemonic(KeyEvent.VK_F);
    edit.setMnemonic(KeyEvent.VK_E);
    format.setMnemonic(KeyEvent.VK_O);
    help.setMnemonic(KeyEvent.VK_H);
    // MenuItem
    create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    findRep.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
    selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
    time.setAccelerator(KeyStroke.getKeyStroke("F5"));

    // 事件监听者
    save.addActionListener(this);
    create.addActionListener(this);
    open.addActionListener(this);
    saveAs.addActionListener(this);
    exit.addActionListener(this);
    undo.addActionListener(this);
    cut.addActionListener(this);
    copy.addActionListener(this);
    paste.addActionListener(this);
    selectAll.addActionListener(this);
    time.addActionListener(this);
    font.addActionListener(this);
    about.addActionListener(this);
    cut2.addActionListener(this);
    copy2.addActionListener(this);
    paste2.addActionListener(this);
    selectAll2.addActionListener(this);
    findRep.addActionListener(this);
    // 设置撤销文本的管理器
    textarea.getDocument().addUndoableEditListener(um);
    textarea.setFont(Format.font);
    // 从配置文件读出color配置
    if (Objects.equals(settings.get("editor").get("color").toString(), "red")) {
      textarea.setForeground(Color.red);
    }
    // 文件
    file.add(create);
    file.add(open);
    file.add(save);
    file.add(saveAs);
    file.addSeparator();
    file.add(exit);

    // 编辑
    edit.add(undo);
    edit.addSeparator();
    edit.add(cut);
    edit.add(copy);
    edit.add(paste);
    edit.addSeparator();
    edit.add(findRep);
    edit.addSeparator();
    edit.add(selectAll);
    edit.addSeparator();
    edit.add(time);

    // 格式
    format.add(font);

    // 帮助
    help.add(about);

    // 菜单栏
    menubar.add(file);
    menubar.add(edit);
    menubar.add(format);
    menubar.add(help);

    // 右键菜单
    popup.add(cut2);
    popup.add(copy2);
    popup.add(paste2);
    popup.addSeparator();
    popup.add(selectAll2);

    // 添加到文本域容器
    textarea.add(popup);

    // 匿名内部类监听器右键动作
    textarea.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
          popup.show(textarea, e.getX(), e.getY());
        }
      }
    });

    // 边界布局
    this.add(menubar, BorderLayout.NORTH);
    this.add(scroll, BorderLayout.CENTER);
    this.setTitle("Text Editor");
    this.setSize(800, 900);
    this.setLocationRelativeTo(null);
    /*this.setIconImage(new ImageIcon(this.getClass().getResource("/icon/notepad.png")).getImage());//图标放在源目录的icon文件夹*/
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.setVisible(true);

  }

  // 重写actionPerformed
  @Override
  public void actionPerformed(ActionEvent e) {
    // Event对象发生源
    if (e.getSource() == open) {

      JFileChooser chooser = new JFileChooser();
      FileNameExtensionFilter filter = new FileNameExtensionFilter("Text document(*.txt)", "txt");
      chooser.setFileFilter(filter);
      chooser.setDialogTitle("Open");
      chooser.showOpenDialog(null);
      chooser.setVisible(true);

      try {
        pathSelect = chooser.getSelectedFile().getPath();
        FileReader wjl = new FileReader(pathSelect);
        BufferedReader hcl = new BufferedReader(wjl);
        String s = "", zfc = "";
        while ((s = hcl.readLine()) != null) {
          zfc += (s + "\n");
        }
        textarea.setText(zfc);

      } catch (Exception ignored) {
      }
    }

    // 保存 || 另存为
    if (e.getSource() == save || e.getSource() == saveAs) {
      if (pathSelect == null) {
        JFileChooser chooser = new JFileChooser();
        new FileSave(chooser, textarea);
      } else {
        try {
          PrintStream ps = new PrintStream(pathSelect);
          ps.write(textarea.getText().getBytes());
          ps.flush();
          ps.close();
        } catch (IOException ex) {
          ex.printStackTrace();
        }
      }
    } else if (e.getSource() == create) {
      textarea.setText("");
      pathSelect = null;
    } else if (e.getSource() == exit) {
      System.exit(0);
    } else if (e.getSource() == undo && um.canUndo()) {
      um.undo();
    } else if (e.getSource() == cut || e.getSource() == cut2) {
      textarea.cut();
    } else if (e.getSource() == copy || e.getSource() == copy2) {
      textarea.copy();
    } else if (e.getSource() == paste || e.getSource() == paste2) {
      textarea.paste();
    } else if (e.getSource() == findRep) {
      new FindAndReplace(textarea);
    } else if (e.getSource() == selectAll || e.getSource() == selectAll2) {
      textarea.selectAll();
    } else if (e.getSource() == time) {
      String text = textarea.getText() + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
      textarea.setText(text);
    } else if (e.getSource() == font) {
      new Format(textarea);
    } else if (e.getSource() == about) {
      new About();
    }
  }

    /*@Override
    public void actionPerformed(ActionEvent e) {

    }*/
}
