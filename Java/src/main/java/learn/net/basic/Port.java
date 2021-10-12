/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-01 01:14:02
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 11:03:32
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\basic\Port.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.basic;

import java.net.InetSocketAddress;

public class Port {
  public static void main(String[] args) {
    InetSocketAddress socketAddress = new InetSocketAddress("localhost", 8080);
    System.out.println(socketAddress);

    System.out.println(socketAddress.getAddress());
    System.out.println(socketAddress.getHostName());
    System.out.println(socketAddress.getPort());
  }
  /**
    localhost/127.0.0.1:8080
    localhost/127.0.0.1
    localhost
    8080
   */
}
