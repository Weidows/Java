/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-26 15:15:20
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-26 15:29:36
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo1.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

public class Demo1 {
  public static void main(String[] args) throws ClassNotFoundException {
    //方式一：通过对象获取
    Class c1 = new Student().getClass();
    System.out.println(c1);

    //方式二：通过forname获取
    Class c2 = Class.forName("twenty_one.reflection.Person");
    System.out.println(c2);

    //通过类名.class获得(最可靠,高效)
    Class c3 = Student.class;
    System.out.println(c3);

    //方式四：基本内置类型的包装类都有一个TYPE属性
    Class c4 = Integer.TYPE;
    System.out.println(c4);
  }
}

class Person {
  public String name;

  public Person() {
  }

  public Person(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Person{" + "name='" + name + '\'' + '}';
  }
}

class Student extends Person {
  public Student() {
    this.name = "Student";
  }
}

class Teacher extends Person {
  public Teacher() {
    this.name = "Teacher";
  }
}
