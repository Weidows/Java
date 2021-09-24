/*
 * @Author: Weidows
 * @Date: 2020-11-01 11:24:32
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-02 22:58:31
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\reflection\Reflection.java
 * @Description:反射机制
 */
package twenty.november.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import twenty.november.reflection.person.Student;

public class Reflection {
  Class student = Student.class;

  //父类和接口
  public void test_1() {
    Class superClass = student.getSuperclass();
    System.out.println("父类: " + superClass.getName());
    Class[] interfaces = student.getInterfaces();
    for (Class cla : interfaces) {
      System.out.println("接口: " + cla.getName());
    }
    System.out.println("-------------------------------------------------");
  }

  //获取构造方法.getDeclaredConstructor()才能get到private方法
  public void test_2() {
    Constructor[] constructors = student.getDeclaredConstructors();
    for (Constructor c : constructors) {
      System.out.println("构造器: " + Modifier.toString(c.getModifiers()));
      System.out.print("参数: ");
      Class[] parameterTypes = c.getParameterTypes();
      for (Class para : parameterTypes) {
        System.out.print(para.getName() + "\t");
      }
      System.out.println("\n-------------------------------------------------");
    }
  }

  //用反射的构造器创建对象
  public void test_3() {
    try {
      ///用默认构造器
      Student student_2 = (Student) student.newInstance();//? 这里就不能传参了
      student_2.showInfo();

      ///get指定参数的构造器
      Class[] cs = { String.class, int.class };
      // Constructor c = student.getConstructor(cs);
      // Student student_3 = (Student) c.newInstance("张三", 18);
      Student student_3 = (Student) student.getConstructor(cs).newInstance("张三", 18); //? 结合性写法
      student_3.showInfo();

      ///强制使用指定private构造器
      Constructor c = student.getDeclaredConstructor(String.class);
      c.setAccessible(true);
      Student student_4 = (Student) c.newInstance("第一中学");
      student_4.showInfo();
      System.out.println("-------------------------------------------------");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //获取方法(与类基本相同)
  public void test_4() {
    Method[] methods = student.getMethods();
    for (Method m : methods) {
      System.out.println("方法名: " + m.getName());
      System.out.println("修饰符: " + Modifier.toString(m.getModifiers()));
      System.out.println("返回类型: " + m.getReturnType());
      System.out.print("参数: ");
      for (Class para : m.getParameterTypes()) {
        System.out.print(para.getName() + "\t");
      }
      System.out.println("\n-------------------------------------------------");
    }
  }

  //获取类中的属性(成员)
  public void test_5() {
    for (Field f : student.getFields()) {
      System.out.println("属性名称: " + f.getName());
      System.out.println("类型: " + f.getType());
      System.out.println("修饰符: " + Modifier.toString(f.getModifiers()));
      System.out.println("-------------------------------------------------");
    }
  }

  //获取并运行指定方法
  public void test_6() {
    try {
      /**
       * ! 注意这里是通过student反射出method,然后通过s调用method
       *    student.getMethod
       *    .invoke(s)
       */
      Student s = (Student) student.getConstructor().newInstance();
      student.getMethod("setSchool", String.class).invoke(s, "第一中学");
      System.out.println(student.getMethod("getSchool").invoke(s));
      System.out.println("-------------------------------------------------");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  //调用指定属性(与方法基本相同)
  public void test_7() {
    try {
      Student s = (Student) student.getConstructor().newInstance();
      Field f = student.getDeclaredField("school");
      f.setAccessible(true);
      f.set(s, "第一中学");
      System.out.println(f.get(s)); //对对象s取f属性
      System.out.println("-------------------------------------------------");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    Reflection reflection = new Reflection();
    /**
     *! All tested, no errors.
     */
    // reflection.test_1();
    // reflection.test_2();
    // reflection.test_3();
    // reflection.test_4();
    // reflection.test_5();
    // reflection.test_6();
    // reflection.test_7();
  }
}
