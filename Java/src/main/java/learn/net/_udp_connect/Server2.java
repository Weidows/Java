/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 09:11:57
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 11:20:27
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\_udp_connect\Server2.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net._udp_connect;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server2 {
  public static void main(String[] args) throws Exception {
    // 1.准备连接
    DatagramSocket datagramSocket = new DatagramSocket(9999);
    while (true) {
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
    }

    // 3.断开连接
    datagramSocket.close();
    System.out.println("Server已关闭连接.");
  }
}
