/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-03 12:30:48
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 17:08:10
 * @FilePath: \Weidows\Java\src\main\java\homework\done\test\six\Staff.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.six;

import java.io.Serializable;

public class Staff implements Serializable {

  private static String id = null;
  private static String name = null;
  private static String jobTitle = null;

  public Staff() {
    this(id, name, jobTitle);
  }

  public Staff(String id, String name, String jobTitle) {
    this.id = id;
    this.name = name;
    this.jobTitle = jobTitle;
  }

  public static String getJobTitle() {
    return jobTitle;
  }

  public void setJobTitle(String jobTitle) {
    Staff.jobTitle = jobTitle;
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
