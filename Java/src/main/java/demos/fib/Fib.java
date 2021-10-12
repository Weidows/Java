/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-10-11 20:51:47
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:56:53
 * @FilePath: \Java\Java\src\main\java\demos\fib\Fib.java
 *
 * @Description: 斐波那契数列计数
 * 当 n = 15时,求 f() 以及 f(2) 执行次数
 *
 * @!: *********************************************************************
 */
package demos.fib;

public class Fib {
  static int countExecuteFuncF;
  static int countExecuteFuncFn;

  public static void main(String[] args) {
    caller(15);
  }

  static void caller(int n) {
    countExecuteFuncF = 0;
    countExecuteFuncFn = 0;
    System.out.println("结果:  " + f(n) + "\tf()执行次数: " + countExecuteFuncF + "\tF(2)次数: " + countExecuteFuncFn);
  }

  static int f(int n) {
    countExecuteFuncF++;

    if (n <= 2) {
      countExecuteFuncFn++;
      return 1;
    } else
      return f(n - 1) + f(n - 2);
  }
}
