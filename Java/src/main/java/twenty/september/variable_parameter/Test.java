/*
 * @Author: Weidows
 * @Date: 2020-09-11 17:16:46
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-11 17:54:19
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\variable_parameter\Test.java
 */
package twenty.september.variable_parameter;

public class Test {
  public static void main(String[] args) {
    Person p = new Person();
    String[] s = new String[] { "a123", "b4566", "c789" };

    //数组方式
    p.printInfo(s);
    System.out.println("---------------");
    
    //...方式,可以直接传入数据或者通过数组传入
    p.printInfo_2(s);
    System.out.println("---------------");
    p.printInfo_2("a123", "b4566", "c789");
  }
}
