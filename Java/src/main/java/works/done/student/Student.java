/*
 * @Author: Weidows
 * @Date: 2020-10-07 18:48:40
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-21 19:18:11
 * @FilePath: \Weidows\Java\src\main\java\test\homework\done\student\Student.java
 */
package works.done.student;

public class Student {
  private String name;
  private int score;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  /// 无参构造
  public Student() {
  }

  /// 有参构造
  public Student(String name, int score) {
    this.name = name;
    this.score = score;
  }

  /// show方法
  public void show() {
    System.out.println("Name:" + name + "\tScore:" + score);
  }
}
