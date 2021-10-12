/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-02 11:02:04
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 11:45:09
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\file_upload\Client.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.file_upload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    //1、创建一个Socket连接
    Socket socket = new Socket(InetAddress.getByName("localhost"), 9999);

    //2、创建一个输出流
    OutputStream os = socket.getOutputStream();

    //3、读取文件
    FileInputStream fis = new FileInputStream(new File("Java/src/main/java/twenty_one/net/file_upload/upload.png"));

    //4、写出文件
    byte[] buffer = new byte[1024];
    int len;
    while ((len = fis.read(buffer)) != -1) {
      os.write(buffer, 0, len);
    }
    System.out.println("Client传输完毕.");

    //通知服务器，我已经结束了
    socket.shutdownOutput(); //我已经传输完了！

    //确定服务器接收完毕，才能够断开连接
    InputStream inputStream = socket.getInputStream();
    //String byte[]
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer2 = new byte[1024];
    int len2;
    while ((len2 = inputStream.read(buffer2)) != -1) {
      baos.write(buffer2, 0, len2);
    }
    System.out.println(baos.toString());

    //5、关闭资源
    baos.close();
    inputStream.close();
    fis.close();
    os.close();
    socket.close();
    System.out.println("Client已接收到验证并断开连接");
  }
  /**
    Client传输完毕.
    Server通知:接受完毕，Client可以断开了
    Client已接收到验证并断开连接
   */
}
