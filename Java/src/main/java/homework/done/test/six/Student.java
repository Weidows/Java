/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-03 12:30:58
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 12:07:11
 * @FilePath: \Weidows\Java\src\main\java\test\six\Student.java
 * @Description:
 * @!: *********************************************************************
 */
package homework.done.test.six;

import java.io.Serializable;

public class Student implements Serializable {

  private static String id = null;
  private static String name = null;
  private static String program = null;

  public Student() {
    this(id, name, program);
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    Student.program = program;
  }

  public Student(String id, String name, String jobString) {
    this.id = id;
    this.name = name;
    this.program = program;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
