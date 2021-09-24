/*
 * @Author: Weidows
 * @Date: 2020-11-01 09:31:00
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-01 10:04:36
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\RandomAccess.java
 * @Description:随机访问流
 */
package twenty.october.stream;

import java.io.RandomAccessFile;

public class RandomAccess {
  public static void testRead(String path) throws Exception {
    /**
     * <p>随机读文件
     * <p>构造器有两个参数
     * <p>参数1是读写文件的路径/File对象
     * <p>参数2是指定访问模式
     * <p> r只读,rw读写,rwd读写(同步文件内容的更新),rws(同步文件内容和元数据更新)
     */
    RandomAccessFile file = new RandomAccessFile(path, "rw");
    file.seek(0); //设置文件读取起点
    byte[] buffer = new byte[1024];
    int length = 0;
    while ((length = file.read(buffer)) != -1) {
      System.out.println(new String(buffer, 0, length));
    }
    file.close();
    System.out.println("TestRead done!");
  }

  public static void testWrite(String path) throws Exception {
    RandomAccessFile file = new RandomAccessFile(path, "rw");
    /**
     * 从文件末尾追加
     * 如果从文件头或者中间开始写入,新内容会覆盖掉等长度的原内容
     */
    file.seek(file.length());
    file.write("你好\n".getBytes()); //? 奇妙写法
    file.close();
    System.out.println("TestWrite done!");
  }

  public static void main(String[] args) {
    String path = "./Java/src/main/java/twenty/october/stream/5.txt";
    try {
      /**
       * ! All tested, no errors.
       */
      // testRead(path);
      // testWrite(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
