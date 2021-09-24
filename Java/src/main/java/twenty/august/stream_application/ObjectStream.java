/*
 * @Author: Weidows
 * @Date: 2020-08-06 17:29:47
 * @LastEditors: Weidows
 * @LastEditTime: 2020-08-06 18:11:45
 * @FilePath: \Weidows\Java\src\main\java\twenty\august\stream_application\ObjectStream.java
 */
package twenty.august.stream_application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 对象串行化: ObjectInputStream & ObjectOutputStream
 *   readObject() & writeObject()
 *   Serializable接口(使对象串行化)
 */
class Student implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -2687802306556815317L;
  private String name;
  private int age;
  private int grade;

  public Student(String name, int age, int grade) {
    this.name = name;
    this.age = age;
    this.grade = grade;
  }

  public String toString() {
    return name + " " + age + " " + grade;
  }

}

public class ObjectStream {
  public static void main(String[] args) {
    try {
      //!写入对象数据(串行化)
      Student s1 = new Student("John", 18, 5);
      ObjectOutputStream out = new ObjectOutputStream(
          new FileOutputStream("./Java/src/main/java/twenty/august/stream_application/Object.txt"));
      out.writeObject(s1);
      out.close();

      //!读取对象数据(反串行化)
      ObjectInputStream in = new ObjectInputStream(
          new FileInputStream("./Java/src/main/java/twenty/august/stream_application/Object.txt"));
      Student s2 = (Student) in.readObject();
      System.out.println("存入的数据为:" + s2 + "\t是否是同一个对象:" + (s1 == s2));
      in.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}