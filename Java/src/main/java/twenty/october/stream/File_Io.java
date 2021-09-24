/*
 * @Author: Weidows
 * @Date: 2020-10-26 23:44:44
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-31 18:06:19
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\File_Io.java
 */
package twenty.october.stream;

import java.io.File;
import java.io.IOException;

/**
 * File类只能对文件层面进行操作,如果涉及到文件内容,就需要用到输入/输出流了
 */
public class File_Io {
  public static void main(String[] args) {
    //f就是实例化的1.txt
    File f_1 = new File("./Java/src/main/java/twenty/october/stream/1.txt");

    //第二种构造器,其实就是把路径分段了
    File f_2 = new File("./Java/src/main/java", "twenty/october/stream/1.txt");

    //这种不指定文件而是目录的话也可以,对象是这个目录
    File f_3 = new File("./Java/src/main/java/twenty/october/stream");

    //Test_1 : Perfect!
    System.out.println(f_1.getName() + "\t" + f_2.getName() + "\t" + f_3.getName());

    //使用相对路径创建File对象
    File f_4 = new File("src/main/java/twenty/october/stream/File.java");

    /**
     * Test_2 : Nice.
     * .getPath()           输出相对/绝对路径
     * .getAbsolutePath()   输出绝对路径
     */
    System.out.println(f_4.getPath() + "\t" + f_4.getAbsolutePath());

    //返回当前文件/文件夹父级路径
    System.out.println(f_4.getParent());

    //文件重命名(也可以借此更改文件路径)
    f_1.renameTo(new File("./Java/src/main/java/twenty/october/stream/2.txt"));
    System.out.println(f_1.getName()); //f_1对象指向1.txt,只会输出1.txt
    // 再改回来
    new File("./Java/src/main/java/twenty/october/stream/2.txt")
        .renameTo(new File("./Java/src/main/java/twenty/october/stream/1.txt"));

    //检测文件(夹)是否存在
    File f_5 = new File("./Java/src/main/java/twenty/october/stream/1.txt");
    System.out.println(f_5.exists());

    //新建文件
    File f_6 = new File("./Java/src/main/java/twenty/october/stream/2.txt");
    try {
      f_6.createNewFile(); //创建
    } catch (IOException e) { //IO必然会有这么个异常,需要catch
      e.printStackTrace();
    } finally {
      f_6.delete(); //删除
    }

    /**
     * 创建文件夹
     * 不用catch exception,如果文件夹存在也不会报错
     * 如果用.mkdir()创建文件夹只能一层一层的向里创建,可以使用.mkdirs()创建多级目录
     */
    File f_7 = new File("./Java/src/main/java/twenty/october/stream/新建文件夹");
    f_7.mkdir();
    // f_7.mkdirs();

    //.list() 返回String[]
    File f_8 = new File("./Java/src/main/java/twenty/october/stream");
    for (String s : f_8.list()) {
      System.out.print(s + "\t");
    }
  }
}
