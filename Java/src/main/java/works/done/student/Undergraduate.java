/*
 * @Author: Weidows
 * @Date: 2020-10-21 18:48:15
 * @LastEditors: Weidows
 * @LastEditTime: 2021-01-17 17:13:35
 * @FilePath: \Weidows\Java\src\main\java\homework\done\student\Undergraduate.java
 */
package works.done.student;

public class Undergraduate extends Student {
  private String degree;

  public Undergraduate() {
  }
  public Undergraduate(String name, int score, String degree) {
    super(name, score);
    this.degree = degree;
  }

  @Override
  public void show() {
    super.show();
    System.out.println("Degree:" + degree);
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }
}
