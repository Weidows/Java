/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 09:12:16
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 10:24:54
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\_udp_connect\Client2.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net._udp_connect;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client2 {
  public static void main(String[] args) throws Exception {
    // 0.准备连接
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    DatagramSocket datagramSocket = new DatagramSocket();

    while (true) {
      // 1.准备数据
      System.out.println("Client准备读取Terminal数据:");
      String readLine = bufferedReader.readLine();
      byte[] bytes = readLine.getBytes();
      DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, new InetSocketAddress("localhost", 9999));

      // 2.发送数据
      datagramSocket.send(datagramPacket);
      System.out.println("Client已经发送数据.");

      if (readLine.equals("quit")) {
        break;
      }
    }

    // 3.断开连接
    datagramSocket.close();
    System.out.println("Client已关闭连接.");
  }
}
