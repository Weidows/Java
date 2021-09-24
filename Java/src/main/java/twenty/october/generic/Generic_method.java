/*
 * @Author: Weidows
 * @Date: 2020-10-25 15:31:38
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-25 17:34:54
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\generic\Generic_method.java
 */
package twenty.october.generic;

public class Generic_method {
  /**
   *  / 无返回值
   */
  public <T> void test(T t) {
    // T test = t;
  }

  /**
   * / 带返回值
   * <p> 需要注意单凭有无返回值无法Overwrite方法,因为参数区分不开
   */
  public <T> T test_1(T t) {
    return t;
  }

  /**
   * / 可变参数的方法
   * <p>可能会存在安全性问题,会有提示Type safety
   */
  public <T> T test_2(T... t) {
    return t[0];
  }

  /**
   * / 静态泛型方法
   * <p>这里面不能使用类的泛型,必须使用泛型方法自己定义的泛型
   */
  public static <T> T test_static(T t) {
    return t;
  }
}

class Test_method {
  public static void main(String[] args) {
    Generic_method g = new Generic_method();
    System.out.println(g.test_1(123) + "\t" + g.test_1("abc"));
  }
}
