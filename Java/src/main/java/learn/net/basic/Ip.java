/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-01 00:39:03
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-02 11:03:09
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\basic\Ip.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ip {

  public static void main(String[] args) {
    // write your code here
    try {
      // 获取本机内网IP地址
      InetAddress inetAddress1 = InetAddress.getByName("127.0.0.1");
      System.out.println(inetAddress1);
      InetAddress inetAddress2 = InetAddress.getByName("localhost");
      System.out.println(inetAddress2);
      InetAddress inetAddress3 = InetAddress.getLocalHost();
      System.out.println(inetAddress3);

      //查询网站ip地址
      InetAddress inetAddress4 = InetAddress.getByName("www.bilibili.com");
      System.out.println(inetAddress4);

      //常用方法
      System.out.println(inetAddress4.getAddress());
      System.out.println(inetAddress4.getCanonicalHostName()); //规范的名字
      System.out.println(inetAddress4.getHostAddress()); //ip
      System.out.println(inetAddress4.getHostName()); //域名，或者自己电脑的名字
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
  }
  /**
    /127.0.0.1
    localhost/127.0.0.1
    DESKTOP-CTDDD3K/192.168.114.1
    www.bilibili.com/121.17.123.130
    [B@2a3046da
    121.17.123.130
    121.17.123.130
    www.bilibili.com
   */
}
