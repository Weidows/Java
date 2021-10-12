/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 11:56:12
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 12:30:53
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\chat\TalkReceive.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TalkReceive implements Runnable {
  DatagramSocket datagramSocket = null;
  private int localPort;

  public TalkReceive(int localPort) {
    this.localPort = localPort;

    try {
      datagramSocket = new DatagramSocket(this.localPort);
    } catch (SocketException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    // 1.准备连接
    while (true) {
      try {
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
        System.out.println("Server准备接收数据中.");

        // 2.接收数据
        datagramSocket.receive(datagramPacket);

        String string = new String(datagramPacket.getData());
        System.out.println("接收到数据:\t" + datagramPacket.getAddress() + ":" + datagramPacket.getPort() + "\t" + string);

        // 这里的string="quitxxxxxxxxxxxxxx",总长为上面的1024,用.equals()无法判断.
        if (string.contains("quit")) {
          break;
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    // 3.断开连接
    datagramSocket.close();
    System.out.println("Server已关闭连接.");
  }

  public static void main(String[] args) {

  }
}
