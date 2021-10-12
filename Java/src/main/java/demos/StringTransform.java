/*
 * @Author: Weidows
 * @Date: 2020-11-18 18:45:07
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:13:39
 * @FilePath: \Java\Java\src\main\java\demos\StringTransform.java
 * @Description:
 */
package demos;

import java.util.Scanner;

public class StringTransform {
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
