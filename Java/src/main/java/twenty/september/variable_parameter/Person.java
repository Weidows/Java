/*
 * @Author: Weidows
 * @Date: 2020-09-11 17:02:44
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-11 17:59:27
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\variable_parameter\Person.java
 */
package twenty.september.variable_parameter;

public class Person {
  /**
   * 用数组的方式传递可变个数的参数
   */
  public void printInfo(String[] s) {
    for (String i : s) {
      System.out.println(i);
    }
  }

  /**
   * 用java特有的...方式传递
   * 这个参数位置可以填入0~n个对应类型的数据
   * 如果有多个形参,可变参数一定要声明在最后,比如
   *  printInfo_2(String...s,int d) 这样是不对的,应该写成
   *  printInfo_2(int d,String...s)
   */
  public void printInfo_2(String...s) {
    for (String i : s) {
      System.out.println(i);
    }
  }
}
