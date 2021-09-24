/*
* @Author: Weidows
* @Date: 2020-07-04 10:39:19
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-24 10:57:23
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\foreach\foreach.java
* for-each循环(增强型for循环) && Object泛型
*/
package twenty.july.foreach;

import java.util.ArrayList;

public class foreach {
  static String[] strs = { "aaa", "bbb", "ccc" };

  public static void main(String[] args) {
    ArrayList<Object> list = new ArrayList<Object>();// 创建ArrayList集合
    list.add(10086);// 向该集合中添加元素
    list.add("你好");
    list.add('a');
    list.add("bbbb");
    /**
     * 增强for循环(for-each循环)
     * 对于list中每个object进行操作,像是对此情况,把Object换成String,其操作并不是只对String,而是会报错,因为数据类型不同(Object是泛型)
     */
    for (Object obj : list) {// 使用增强for循环遍历集合
      System.out.print(obj + "\t");// 取出并打印集合中的元素
    }

    /**
     * 测试2.for-each是(伪)只读循环,不能修改数据. 原因是其只是将临时变量str重定向了,未修改数组的.
     * 虽然无法经由临时变量直接修改数据,但是可以通过临时变量调用函数之类的操作间接修改
     * 比如对于strs数组str是"复制"关系,而当str是某对象的管理者时可以修改对象的数据
     */
    for (String str : strs) {
      str = "ddd";
      System.out.println(str);
    }
    System.out.println("foreach循环修改后的数组:" + strs[0] + "," + strs[1] + "," + strs[2]);
    // for循环遍历数组
    for (int i = 0; i < strs.length; i++) {
      strs[i] = "ddd";
    }
    System.out.println("for循环修改后的数组:" + strs[0] + "," + strs[1] + "," + strs[2]);
  }
}