/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 11:31:36
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 12:09:56
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\chat\TalkSend.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class TalkSend implements Runnable {
  BufferedReader bufferedReader = null;
  DatagramSocket datagramSocket = null;

  private String targetIP;
  private int targetPort;

  public TalkSend(String targetIP, int targetPort) {
    this.targetIP = targetIP;
    this.targetPort = targetPort;

    try {
      // 0.准备连接
      bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      datagramSocket = new DatagramSocket();
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {

  }

  @Override
  public void run() {
    while (true) {
      // 1.准备数据
      System.out.println("Client准备读取Terminal数据:");
      try {
        String readLine = bufferedReader.readLine();
        byte[] bytes = readLine.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length,
            new InetSocketAddress(targetIP, targetPort));

        // 2.发送数据
        datagramSocket.send(datagramPacket);
        System.out.println("Client已经发送数据.");

        if (readLine.equals("quit")) {
          break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // 3.断开连接
    datagramSocket.close();
    System.out.println("Client已关闭连接.");
  }
}
