/*
 * @Author: Weidows
 * @Date: 2020-10-23 20:45:28
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-25 15:31:18
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\generic\Generic_class.java
 */
package twenty.october.generic;

public class Generic_class {
  public static void main(String[] args) {
    //在new A的对象时指定泛型的类型
    Class_A<String> a1 = new Class_A<String>();
    a1.setKey("XXX");
    System.out.println("a1: " + a1.getKey());

    Class_A<Integer> a2 = new Class_A<Integer>();
    a2.setKey(123);
    System.out.println("a2: " + a2.getKey());

    Class_A<Object> a3 = new Class_A<Object>();
    Class_A a4 = new Class_A(); //? 不指定泛型,相当于Object类型,与上面效果相等
    a3.setKey("123");
    System.out.println(a3.getKey());

  }
}

/**
 * ! 泛型类
 * 泛型T可以任意起名,一般用T (意为type)
 * 这个指定类型通过下面的'T'来引用
 */
class Class_A<T> {
  private T key;

  public void setKey(T key) {
    this.key = key;
  }

  public T getKey() {
    return key;
  }
}
