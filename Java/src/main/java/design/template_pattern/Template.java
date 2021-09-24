/*
 * @Author: Weidows
 * @Date: 2020-10-14 23:55:07
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-16 20:02:56
 * @FilePath: \Weidows\Java\src\main\java\design\template_pattern\Template.java
 */

package design.template_pattern;

public abstract class Template {
  public abstract void code();

  /**
   * 抽象类中带方法体的非抽象final方法
   */
  public final void getTime() {
    long start = System.currentTimeMillis();
    code();
    long end = System.currentTimeMillis();

    System.out.println("code执行时间:" + (end - start));
  }
}

class TestTemp extends Template {
  @Override
  public void code() {
    int k = 0;
    for (int i = 0; i < 5000; i++) {
      k += 1;
    }
    System.out.println(k);
  }
}