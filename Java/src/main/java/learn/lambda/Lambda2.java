/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-19 16:46:08
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:02:26
 * @FilePath: \Java\Java\src\main\java\learn\lambda\Lambda2.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.lambda;

public class Lambda2 {
  public static void main(String args[]) {
    /**
     * 这里的局部变量就算不声明final也可以被Lambda表达式引用
     * 但是无论声不声明,被引用后后续都不可修改,会报错
     */
    final int num = 1;

    Converter<Integer, String> s = (param) -> System.out.println(String.valueOf(param + num));

    // Lambda表达式参数不能与外部变量同名,编译报错
    // Converter<Integer, String> s1 = (num) -> System.out.println(num);

    s.convert(2); // 输出结果为 3
  }

  public interface Converter<T1, T2> {
    void convert(int i);
  }
}
