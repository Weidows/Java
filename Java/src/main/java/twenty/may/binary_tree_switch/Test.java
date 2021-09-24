package twenty.may.binary_tree_switch;

/*
 * @Author: Weidows
 * @Date: 2020-05-29 01:15:59
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:52:28
 * @FilePath: \Weidows\Java\src\main\java\twenty\may\binary_tree_switch\Test.java
 * 
 * 
 * 级联 && 二叉树   特殊:switch和C语言一样
 */
import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("分别输入x,y,z");
    int x = in.nextInt();
    int y = in.nextInt();
    int z = in.nextInt();
    in.close();
    int max = 0;
    // 级联二叉树
    if (x > y) {
      if (x > z) // 如果未加{},那么if只用if下一行,即使下下行的缩进相同
        max = x;
      else // else和最近的if匹配,即使缩进不同
        max = z;
    } else { // 这里最好别写成else if,影响程序可读性
      if (y > z)
        max = y;
      else
        max = z;
    }
    System.out.println("max=" + max);
  }
}
