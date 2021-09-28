package homework.assignment.test;

import org.junit.jupiter.api.Test;

import homework.assignment.Address;
import homework.assignment.Course;
import homework.assignment.Student;

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
