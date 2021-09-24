/*
 * @Author: Weidows
 * @Date: 2020-11-18 18:45:07
 * @LastEditors: Weidows
 * @LastEditTime: 2021-01-17 17:13:16
 * @FilePath: \Weidows\Java\src\main\java\homework\done\string_transfer\Test.java
 * @Description:
 */
package homework.done.string_transfer;

import java.util.Scanner;

public class Test {
  public static String transfer(String s) {
    String outputString = "";
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      // if (c < 'A' && c >= 'a') {
      if (c >= 'a') {
        c = String.valueOf(c).toUpperCase().charAt(0);
      } else if (c >= 'A') {
        c = String.valueOf(c).toLowerCase().charAt(0);
      }
      outputString += String.valueOf(c);
    }
    return outputString;
  }

  public static String transfer_2(String s) {
    StringBuffer outputString = new StringBuffer();
    for (int i = s.length() - 1; i >= 0; i--) {
      char c = s.charAt(i);
      if (c >= 'a') {
        c = String.valueOf(c).toUpperCase().charAt(0);
      } else if (c >= 'A') {
        c = String.valueOf(c).toLowerCase().charAt(0);
      }
      outputString.append(c);
    }
    return outputString.toString();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String inputString = in.next();
    System.out.println(transfer(inputString));
    System.out.println(transfer_2(inputString));
    in.close();
  }
}
