/*
 * @Author: Weidows
 * @Date: 2020-12-02 18:44:00
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:11:27
 * @FilePath: \Java\Java\src\main\java\demos\RandomNum.java
 * @Description:
 */
package demos;

import java.util.Random;

public class RandomNum {
  public static void main(String[] args) {
    getRandomNum(20, 30, 10);
  }

  // 获取 m ~ n 之间的 a 个随机数,每5个换行
  static void getRandomNum(int m, int n, int a) {
    for (int i = 0; i < a; i++) {
      int number = m + new Random().nextInt(n - m + 1);
      System.out.print(number + "\t");
      if (i % 5 == 4)
        System.out.println();
    }
  }
}
