/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-01 23:53:45
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 10:25:09
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\tcp_connect\Client.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.tcp_connect;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws Exception {
    //1、要知道服务器的地址，端口号
    InetAddress address = InetAddress.getLocalHost();

    int port = 9999;

    //2、创建一个socket连接
    Socket socket = new Socket(address, port);

    //3、发送消息 IO流
    OutputStream outputStream = socket.getOutputStream();
    outputStream.write("Weidows connecting here.".getBytes());
    // outputStream.write("quit".getBytes());

    //4.关闭通道
    outputStream.close();
    socket.close();
  }
}
