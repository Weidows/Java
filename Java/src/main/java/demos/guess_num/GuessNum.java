/*
* @Author: Weidows
* @Date: 2020-05-29 01:15:59
* @LastEditors: Weidows
* @LastEditTime: 2020-10-20 17:52:46
* @FilePath: \Weidows\Java\src\main\java\twenty\may\guess_num\GuessNum.java
* 
* 
* 100以内猜数游戏
*/
package demos.guess_num;

import java.util.Scanner;

public class GuessNum {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int number = (int) (Math.random() * 100 + 1); // random生成[0,1)
    int a = 0;
    int cont = 0;
    System.out.println("开始");
    do {
      System.out.print("请输入:");
      a = in.nextInt();
      cont++;
      if (a > number)
        System.out.println("偏大");
      else
        System.out.println("偏小");
    } while (a != number);
    in.close();
    System.out.println("猜对了,猜了" + cont + "次");
  }
}
