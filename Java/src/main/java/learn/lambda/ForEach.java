/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-19 17:05:08
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-19 17:18:34
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\lambda\ForEach.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ForEach {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(Arrays.asList("I", "love", "you", "too"));

    // 使用增强for循环迭代
    for (String str : list) {
      if (str.length() > 3)
        System.out.println(str);
    }

    // implement Consumer interface
    list.forEach(new Consumer<String>() {
      @Override
      public void accept(String t) {
        if (t.length() > 3)
          System.out.println(t);
      }
    });

    // Lambda implement Consumer
    list.forEach(s -> {
      if (s.length() > 3)
        System.out.println(s);
    });
  }
}
