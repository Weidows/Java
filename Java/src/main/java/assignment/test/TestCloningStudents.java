package assignment.test;

import assignment.Address;
import assignment.Course;
import assignment.Student;
import org.junit.jupiter.api.Test;

public class TestCloningStudents {
  @Test
  void testClone() {
    Student student1 = new Student();
    Address address = new Address();
    Course course = new Course();

    student1.setAddress(address);
    student1.setCourse(course);

    Student student2 = null;
    try {
      student2 = student1.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }


    //false : deep clone
    System.out.println(student2.getAddress() == address);
    //true : shadow clone
    System.out.println(student2.getCourse() == course);
  }
}
