/*
 * @Author: Weidows
 * @Date: 2020-10-31 23:45:48
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-01 09:38:41
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\stream\ObjectStream.java
 * @Description:对象序列/反序列化流
 * 要让对象可序列化,那个类必须implements Serializable接口
 * 只有序列化后的对象数据才可以进行网络传播(网络只能传输二进制数据)
 * 序列化与反序列化使用的类要严格一直
 */
package twenty.october.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ObjectStream {
  public static void testObjectOutputStream(String outputPath) throws Exception {
    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(outputPath));
    Person p = new Person("Tom", 18);
    output.writeObject(p);
    output.flush();
    output.close();
    System.out.println("TestObjectOutputStream done!");
  }

  public static void testObjectInputStream(String inputPath) throws Exception {
    ObjectInputStream input = new ObjectInputStream(new FileInputStream(inputPath));
    Person p = (Person) input.readObject();
    input.close();
    System.out.println(p.getName() + "\t" + p.getAge());
    System.out.println("testObjectInputStream done!");
  }

  public static void main(String[] args) {
    String path = "./Java/src/main/java/twenty/october/stream/object.txt";
    try {
      /**
       * ! All tested, no errors.
       */
      // testObjectOutputStream(path);
      // testObjectInputStream(path);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

/**
 * @description: 随便写的个类
 * @param {*}
 * @return {*}
 */
class Person implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -5409387029951054564L;
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
