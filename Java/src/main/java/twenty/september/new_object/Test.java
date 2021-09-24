/*
 * @Author: Weidows
 * @Date: 2020-09-04 17:42:06
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-07 11:10:02
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\new_object\test.java
 */
package twenty.september.new_object;

import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    in.close();
    // new Person();
    // new Person();
    Person p = new Person() {
      /**
       * ! 这是一个匿名内部类
       * 因为这种内部类没有类名,也就无法搞一个新的构造器(用的还是原来Person的)
       * 也就是这个类初始化后的成员变量还是跟原来的Person类的一样
       *  这里就会用到代码块来初始化类的属性
       */
      { ///这里这种代码块就可以替代构造器使用
        this.name = "李四";
        /**
         * 这里无论写this.name/name/super.name都会变为"李四"
         */
      }

      @Override
      public void test() {
        System.out.println("执行的是被Override的Person");
      }
    };
    System.out.println("这个类里面的name是:\t" + p.name);
    p.test();
  }
}
