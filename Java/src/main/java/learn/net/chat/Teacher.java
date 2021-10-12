/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 12:10:32
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 12:28:48
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\chat\Teacher.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.chat;

public class Teacher {
  public static void main(String[] args) {
    // 老师
    new Thread(new TalkReceive(7777)).start();
    new Thread(new TalkSend("localhost", 8888)).start();
  }
  /**
    Server准备接收数据中.
    Client准备读取Terminal数据:
    接收到数据:     /127.0.0.1:50277        15465
    Server准备接收数据中.
    123456
    Client已经发送数据.
    Client准备读取Terminal数据:
   */
}
