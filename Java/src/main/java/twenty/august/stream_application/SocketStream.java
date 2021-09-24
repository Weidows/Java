/*
 * @Author: Weidows
 * @Date: 2020-08-06 16:43:35
 * @LastEditors: Weidows
 * @LastEditTime: 2020-08-06 17:26:03
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\stream_application\SocketStream.java
 */
package twenty.august.stream_application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SocketStream {
  public static void main(String[] args) {
    try {
      //! socket输出流
      Socket socket = new Socket(InetAddress.getByName("localhost"), 12345);
      PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
      out.println("Hello");
      out.flush();//? 刷新缓冲区
      out.close();
      socket.close();

      //! socket输入流
      BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      String line = in.readLine();
      System.out.println(line);
      in.close();
      
      /**
       * ! 这种read()情形就会使得服务端处于阻塞状态(在读入东西前无法执行任何操作)
       *    ?解决方案:
       *      设置多线程(将socket放进单独的线程里)
       *      使用nio的channel选择机制
       *      对于socket,设置SO时间setSoTimeout(int timeOut)
       */
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}