/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-02 23:23:26
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 00:19:40
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\_udp_connect\Server.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net._udp_connect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
  public static void main(String[] args) throws Exception {
    // 1.开放端口
    DatagramSocket datagramSocket = new DatagramSocket(9999);
    System.out.println("等待数据传入中...");

    // 2.接收数据
    byte[] buffer = new byte[1024];
    DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
    datagramSocket.receive(datagramPacket); //阻塞接收

    // 3.输出
    System.out.println("Server接收到数据:" + new String(datagramPacket.getData()));

    // 4.关闭
    datagramSocket.close();
  }
}
