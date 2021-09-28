package homework.assignment.utils;

import java.io.*;
import java.util.Collection;

import homework.assignment.Student;

/**
 * 尝试过通过while循环存入/读取object
 * 但是尝试后发现: 如果读取次数>存入数量,会出现EOFException
 * 于是改为直接存储Collection对象: 只读取/存储一次,避免异常
 */
public class StudentStorage {
  private static ObjectOutputStream objectOutputStream = null;
  private static ObjectInputStream objectInputStream = null;

  public static void save(Collection<Student> students, File file) throws IOException {
    objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
    writeData(students);
  }

  public static void save(Collection<Student> students, String fileName) throws IOException {
    objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName));
    writeData(students);
  }

  public static Collection<Student> load(File file) throws IOException {
    objectInputStream = new ObjectInputStream(new FileInputStream(file));
    Collection<Student> students = null;
    //题目要求不能抛出这个异常,在这里捕获
    try {
      students = (Collection<Student>) objectInputStream.readObject();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    System.out.println("Successfully load object from file.\n");
    return students;
  }

  //两个save方法中不能有重复代码,所以抽离出来了这个方法
  private static void writeData(Collection<Student> students) throws IOException {
    objectOutputStream.writeObject(students);
    objectOutputStream.close();
    System.out.println("Successfully write object to file.\n");
  }
}
