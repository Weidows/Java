/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-03 12:30:36
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 17:08:00
 * @FilePath: \Weidows\Java\src\main\java\homework\done\test\six\Serializer.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.six;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;

public class Serializer {

  @Override
  public String toString() {
    return "Serializer []";
  }

  public static void main(String[] args) throws Exception {
    Collection<Object> objects = new ArrayList<>();
    String fileName = "objects.csv";

    Student student1 = new Student();
    student1.setId("1100");
    student1.setName("John");
    student1.setProgram("CS");
    objects.add(student1);

    Student student2 = new Student();
    student2.setId("1122");
    student2.setName("Sarah");
    student2.setProgram("SE");
    objects.add(student2);

    Staff staff1 = new Staff();
    staff1.setId("0011");
    staff1.setName("Son");
    staff1.setJobTitle("Tutor");
    objects.add(staff1);

    save(objects, fileName); // implement this method below

    // load(fileName); // implement this method below

  }

  private static void save(Collection<Object> objects, String fileName) throws Exception {
    ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));

    objects.forEach((object) -> {
      try {
        os.writeObject(object);
        os.writeChar('\n');
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    os.close();
  }

  private static void load(String fileName) throws Exception {
    ObjectInputStream oi = new ObjectInputStream(new FileInputStream(fileName));

    while (oi.read() != -1) {
      Object object = oi.readObject();

      if (object instanceof Student) {
        Student s = (Student) object;
        System.out.println(s.getId() + " " + s.getName() + " " + s.getProgram());
      } else if (object instanceof Staff) {
        Staff s = (Staff) object;
        System.out.println(s.getId() + " " + s.getName() + " " + s.getJobTitle());
      }
    }

    oi.close();
  }
}
