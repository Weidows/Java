package assignment.test;

import assignment.Student;
import assignment.utils.StudentStorage;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class TestPersistency {
  Collection<Student> list1 = null;
  Collection<Student> list2 = null;

  @Test
  void testSave() {
    list1 = new ArrayList<>();
    list1.add(new Student());
    list1.add(new Student());
    list1.add(new Student());
    try {
      StudentStorage.save(list1, "src/main/java/assignment/test/storage.dat");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void testLoad() {
    try {
      list2 = StudentStorage.load(new File("src/main/java/assignment/test/storage.dat"));
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println("list2(input) :");
    for (Student student : list2) {
      System.out.println("\t" + student);
    }
    System.out.println();
  }

  @Test
  void compare() {
    testSave();
    testLoad();
    System.out.println("is list1(output) == list2(input) : " + list1.equals(list2));
  }
}
