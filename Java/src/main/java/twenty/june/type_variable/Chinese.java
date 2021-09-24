/*
 * @Author: Weidows
 * @Date: 2020-09-28 09:41:36
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-28 09:45:37
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\type_variable\Chinese.java
 */
package twenty.june.type_variable;

public class Chinese {
  public static String country = "中国";
  public static int chinese_count = 0;//计数器,计算new了多少中国人
  String name;
  int age;

  public Chinese(String name, int age) {
    this.name = name;
    this.age = age;
    chinese_count++;//每new一个就会+1
  }
}
