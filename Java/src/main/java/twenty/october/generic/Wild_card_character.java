/*
 * @Author: Weidows
 * @Date: 2020-10-25 17:29:07
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-25 23:52:16
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\generic\Wild_card_character.java
 */
package twenty.october.generic;

import java.util.ArrayList;
import java.util.List;

public class Wild_card_character {
  /**
   * / 必须传入B的子类
   */
  public void test_1(List<? extends B> list) {

  }

  /**
   * / 必须传入B的父类
   */
  public void test_2(List<? super B> list) {

  }

  /**
   * / 必须传入实现接口的类
   */
  public void test_3(List<? extends D> list) {

  }

  public static void main(String[] args) {
    Wild_card_character w = new Wild_card_character();
    w.test_1(new ArrayList<C>());//B的子类
    w.test_2(new ArrayList<A>());//B的父类
    w.test_3(new ArrayList<C>());//接口D的实现类
  }
}

class A {
}

class B extends A {
}

class C extends B implements D {
}

interface D {

}
