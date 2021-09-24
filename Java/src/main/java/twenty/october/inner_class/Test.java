/*
 * @Author: Weidows
 * @Date: 2020-10-19 23:51:39
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 00:10:20
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\inner_class\Test.java
 */
package twenty.october.inner_class;

/**
 * Java中内部类只要为了解决'多继承'问题
 */
public class Test {
  public static void main(String[] args) {
    A a = new A();
    {
      a.testB();
      a.testC();
    }
  }
}

class A {
  public void testB() {
    new InnerB().testB();
  }

  public void testC() {
    new InnerC().testC();
  }

  ///Inner class B
  private class InnerB extends B {
    @Override
    public void testB() {
      super.testB();
      System.out.println("class A - InnerB - testB");
    }
  }

  ///Inner class C
  private class InnerC extends C {
    @Override
    public void testC() {
      super.testC();
      System.out.println("class A - InnerC - testC");
    }
  }
}

class B {
  public void testB() {

  }
}

class C {
  public void testC() {

  }
}
