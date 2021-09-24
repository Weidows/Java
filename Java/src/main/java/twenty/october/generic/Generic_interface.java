/*
 * @Author: Weidows
 * @Date: 2020-10-25 15:03:14
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-25 15:29:46
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\generic_class\Generic_interface.java
 */
package twenty.october.generic;

/**
 * ! 泛型接口
 */
public interface Generic_interface<T> {
  void test(T t);
}

/**
 * / 实现1 
 * 接口泛型没传入参数,实现类也需要跟接口类一样写个<T>
 */
class B1<T> implements Generic_interface<T> {
  @Override
  public void test(T t) {
  }
}

/**
 * / 实现2
 * 接口泛型传入参数,实现类就不需要声明泛型了(可以直接生成需要Override的方法)
 */
class B2 implements Generic_interface<String> {
  @Override
  public void test(String t) {
  }
}

class Test_interface {
  public static void main(String[] args) {
    Generic_interface b1 = new B1(); //不报错但会提示raw type,相当于传入Object
    Generic_interface b12=new B1<Object>(); //实现类没指定泛型,可以再传入类型
    Generic_interface b2=new B2(); //已经指定泛型类型,就不能再传入类型

    System.out.println("there in test_1");
  }
}
