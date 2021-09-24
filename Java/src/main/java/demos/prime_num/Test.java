
/*
* @Author: Weidows
* @Date: 2020-05-29 01:15:59
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 17:54:43
 * @FilePath: \Weidows\Java\src\main\java\twenty\may\prime_num\Test.java
* 
* 
* 输出num之前的素数 && 零钱凑整问题
*/
package demos.prime_num;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    // 素数
    int num = in.nextInt();
    for (int n = 2; n < num; n++) {
      boolean isPrime = true;
      for (int i = 2; i < n; i++) {
        if (n % i == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime == true)
        System.out.print(n + "\t"); // println是输出后带个ln换行,\t制表符
    }
    // 零钱凑整问题(小钱在外,大钱在内)
    System.out.println(); // 换行
    int amount = in.nextInt();
    OUT: // 标号,跟跳转不同
    for (int one = 0; one <= amount; one++) {
      for (int five = 0; five <= amount / 5; five++) {
        for (int ten = 0; ten <= amount / 10; ten++) {
          for (int twenty = 0; twenty <= amount / 20; twenty++) {
            if (one + five * 5 + ten * 10 + twenty * 20 == amount) {
              System.out.println(one + "张一元," + five + "张五元," + ten + "张十元," + twenty + "张二十元  ->" + amount + "元.");
              break OUT; // 把OUT标记的循环体结束,这里是找到一种就结束,也可以去掉此行输出所有方案
            }
          }
        }
      }
    }
  }
}
