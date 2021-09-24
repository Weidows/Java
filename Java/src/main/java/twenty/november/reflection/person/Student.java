/*
 * @Author: Weidows
 * @Date: 2020-11-01 11:31:57
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-02 22:23:59
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\reflection\person\Student.java
 * @Description:
 */
package twenty.november.reflection.person;

public class Student extends Person implements Move, Study {
  private String school;

  public Student() {
  }

  private Student(String school) {
    this.school = school;
  }

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void showInfo() {
    System.out.println("name: " + name + "\tage: " + age + "\tschool: " + school);
  }

  @Override
  public void moveType() {
    System.out.println("移动");
  }

  @Override
  public void studyInfo() {
    System.out.println("学习");
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }
}
