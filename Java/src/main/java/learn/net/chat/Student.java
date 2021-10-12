/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-03 12:16:41
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-03 12:28:31
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\net\chat\Student.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.net.chat;

public class Student {
  public static void main(String[] args) {
    // 学生
    new Thread(new TalkReceive(8888)).start();
    new Thread(new TalkSend("localhost", 7777)).start();
  }
  /**
    Server准备接收数据中.
    Client准备读取Terminal数据:
    15465
    Client已经发送数据.
    Client准备读取Terminal数据:
    接收到数据:     /127.0.0.1:50279        123456
    Server准备接收数据中.
   */
}
