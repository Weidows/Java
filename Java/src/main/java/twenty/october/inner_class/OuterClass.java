/*
 * @Author: Weidows
 * @Date: 2020-10-19 23:01:22
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-19 23:45:34
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\inner_class\OuterClass.java
 */
package twenty.october.inner_class;

/**
 * ! 静态内部类和非静态内部类之间区别:
   * 0. 只有内部类可以static,最外面的类不可以
   * 1. 静态内部类不需要有指向外部类的引用,但非静态内部类需要,而且非静态内部类不能脱离外部类实体被创建
   * 2. 静态类只能访问外部类的静态成员,非静态内部类能够访问外部类的静态和非静态成员
 */

///下面程序演示如何在java中创建静态内部类和非静态内部类
public class OuterClass {
  private static String msg = "GeeksForGeeks";

  /// 静态内部类
  public static class NestedStaticClass {

    // 静态内部类只能访问外部类的静态成员
    public void printMessage() {

      // 如果试着将上面msg改成非静态的，将导致编译错误 
      System.out.println("Message from nested static class: " + msg);
    }
  }

  /// 非静态内部类
  public class InnerClass {

    // 不管是静态方法还是非静态方法都可以在非静态内部类中访问
    public void display() {
      System.out.println("Message from non-static nested class: " + msg);
    }
  }
}

class Main {
  //? 创建静态内部类和非静态内部类的实例
  public static void main(String args[]) {

    /// 创建静态内部类的实例
    OuterClass.NestedStaticClass printer = new OuterClass.NestedStaticClass();

    // 创建静态内部类的非静态方法
    printer.printMessage();

    /// 为了创建非静态内部类，我们需要外部类的实例
    OuterClass outer = new OuterClass();
    OuterClass.InnerClass inner = outer.new InnerClass();

    // 调用非静态内部类的非静态方法
    inner.display();

    /// 我们也可以结合以上步骤，一步创建的内部类实例
    OuterClass.InnerClass innerObject = new OuterClass().new InnerClass();

    // 同样我们现在可以调用内部类方法
    innerObject.display();
  }
}
