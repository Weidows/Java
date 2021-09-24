/*
 * @Author: Weidows
 * @Date: 2020-09-26 22:01:13
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-28 09:22:58
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\basic_data_type\Basic.java
 */
package twenty.september.basic_data_type;

public class Basic {
  public static void main(String[] args) {
    //! 装箱 (可以调用包装类中的方法)
    Integer i = new Integer(111);
    Integer j = new Integer("111");
    // Integer k = new Integer("abc"); //编译报错,非数字

    System.out.println("i+k= " + i + j);

    //! 拆箱 (转换成基本类型)
    int k = i.intValue();
    System.out.println("k= " + k);

    //! 边装边拆
    boolean b = new Boolean("false").booleanValue();
    System.out.println("b是:" + b);

    //! 自动装/拆箱(1.5之后支持)
    Integer i1 = 112;
    int i2 = i1; //? 也就是.xxxValue()加不加都行了
    Integer i3 = i2; //* 也可以这么装箱

    //! 字符串 <=> 基本数据类型
    int i4 = Integer.parseInt("12345");
    float f = Float.parseFloat("12345.0");
    boolean b1 = Boolean.parseBoolean("false");

    String istr = String.valueOf(i4); //转成字符串,当然(String强转也可以,但不建议)
  }
}
