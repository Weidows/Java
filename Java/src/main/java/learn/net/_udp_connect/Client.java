/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-02 23:23:37
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 00:17:41
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\_udp_connect\Client.java
 * @Description:
 * @!: *********************************************************************
 */

package learn.net._udp_connect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
  public static void main(String[] args) throws Exception {
    // 1.创建数据包
    InetAddress localHost = InetAddress.getLocalHost();
    int port = 9999;
    byte[] data = "这是Client发送的数据.".getBytes();
    DatagramPacket datagramPacket = new DatagramPacket(data, data.length, localHost, port);

    // 2.创建Socket
    DatagramSocket datagramSocket = new DatagramSocket();

    // 3.发送数据
    datagramSocket.send(datagramPacket);
    System.out.println("传输成功.");

    // 4.关闭连接
    datagramSocket.close();
  }
}
