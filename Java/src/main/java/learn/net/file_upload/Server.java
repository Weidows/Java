/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-02 11:01:56
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 11:45:26
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\file_upload\Server.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.file_upload;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws Exception {
    //1、创建服务
    ServerSocket serverSocket = new ServerSocket(9999);

    //2、监听客户端的连接
    Socket socket = serverSocket.accept(); //阻塞式监听，会一直等待客户端连接
    System.out.println("Server开始监听.");

    //3、获取输入流
    InputStream is = socket.getInputStream();

    //4、文件输出
    FileOutputStream fos = new FileOutputStream(new File("Java/src/main/java/twenty_one/net/file_upload/receive.png"));
    byte[] buffer = new byte[1024];
    int len;
    while ((len = is.read(buffer)) != -1) {
      fos.write(buffer, 0, len);
    }
    System.out.println("Server接收完毕.");

    //通知客户端我接收完毕了
    OutputStream os = socket.getOutputStream();
    os.write("Server通知:接受完毕，Client可以断开了".getBytes());

    //5、关闭资源
    fos.close();
    is.close();
    socket.close();
    serverSocket.close();
    System.out.println("Server已发送验证并断开连接.");
  }
  /**
    Server开始监听.
    Server接收完毕.
    Server已发送验证并断开连接.
   */
}
