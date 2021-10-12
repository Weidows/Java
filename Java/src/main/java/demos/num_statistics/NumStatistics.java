/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-10-11 10:36:25
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:58:44
 * @FilePath: \Java\Java\src\main\java\demos\num_statistics\NumStatistics.java
 * @Description:
 * @!: *********************************************************************
 */
package demos.num_statistics;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class NumStatistics {
  private static int num;
  private static int[] numCounts;

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    getNum();
    getNumCountsOfCalculate();
    printNumCounts("output.calculate.txt");
    long endTime = System.currentTimeMillis();
    System.out.println("Time consuming: " + (endTime - startTime) + "ms - calculate");

    startTime = System.currentTimeMillis();
    getNum();
    getNumOfCircle();
    printNumCounts("output.circle.txt");
    endTime = System.currentTimeMillis();
    System.out.println("Time consuming: " + (endTime - startTime) + "ms - circle");
  }

  // 从文件获取输入数据 : int num
  private static void getNum() {
    numCounts = new int[10];
    try {
      DataInputStream input = new DataInputStream(new FileInputStream("Java/src/main/java/demos/num_statistics/input.txt"));
      num = Integer.parseInt(input.readLine());
      input.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 数学计算
  private static void getNumCountsOfCalculate() {
    solveByCalculate(num);

    for (int i = 0; i < String.valueOf(num).length(); i++) {
      numCounts[0] -= Math.pow(10, i);
    }
  }

  private static int solveByCalculate(int num) {
    int length = String.valueOf(num).length();
    int p = Integer.parseInt(String.valueOf(num).substring(0, 1));
    int t = num % (int) Math.pow(10, length - 1);
    int lenT = String.valueOf(t).length();

    for (int i = 0; i < 10; i++) {
      numCounts[i] += p * (length - 1) * (int) Math.pow(10, length - 2);
    }

    for (int i = 0; i < p; i++) {
      numCounts[i] += (int) Math.pow(10, length - 1);
    }

    if (t == 0) {
      numCounts[p]++;
      numCounts[0] += length - 1;
      return 0;
    }

    if (lenT != length - 1) {
      numCounts[0] += (length - 1 - lenT) * (t + 1);
    }

    numCounts[p] += t + 1;
    return solveByCalculate(t);
  }

  // 输出到文件 int[] numCounts
  private static void printNumCounts(String fileName) {
    try {
      OutputStreamWriter writer = new OutputStreamWriter(
          new FileOutputStream("Java/src/main/java/demos/num_statistics/" + fileName));

      for (int i = 0; i < numCounts.length; i++) {
        writer.write(numCounts[i] + "\n");
      }
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // 循环遍历
  private static void getNumOfCircle() {
    for (int temp, i = 1; i <= num; i++) {
      temp = i;
      while (temp != 0) {
        numCounts[temp % 10]++;
        temp /= 10;
      }
    }
  }
}
