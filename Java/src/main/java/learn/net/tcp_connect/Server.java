/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-01 23:53:53
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 10:22:46
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\tcp_connect\Server.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.tcp_connect;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    //1、我得有一个地址
    ServerSocket serverSocket = new ServerSocket(9999);

    while (true) { // 连续接收数据
      //2、等待客户端连接过来
      Socket accept = serverSocket.accept();

      //3、读取客户端的消息
      InputStream inputStream = accept.getInputStream();

      /**
       * 通常IO方式,如果是长数据传输,会导致出错
       *
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) != -1) {
        String s = new String(buffer, 0, length);
        System.out.println(s);
        }
       */

      //4. 管道流接收数据
      ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024];
      int length;
      while ((length = inputStream.read(buffer)) != -1) {
        byteArrayOutputStream.write(buffer, 0, length);
      }
      if (byteArrayOutputStream.toString().matches("quit")) {
        break;
      } else {
        System.out.println(byteArrayOutputStream.toString());
        byteArrayOutputStream.close();
        inputStream.close();
        accept.close();
      }
    }

    //5. 最后关闭
    serverSocket.close();
  }
}
