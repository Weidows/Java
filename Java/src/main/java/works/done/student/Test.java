/*
 * @Author: Weidows
 * @Date: 2020-10-21 18:49:45
 * @LastEditors: Weidows
 * @LastEditTime: 2021-01-17 17:13:27
 * @FilePath: \Weidows\Java\src\main\java\homework\done\student\Test.java
 */
package works.done.student;

public class Test {
  public static void main(String[] args) {
    // Student s1 = new Student("张三", 3);
    // s1.show();

    Undergraduate u1 = new Undergraduate();//空参构造
    u1.setName("李四");
    u1.setScore(4);
    u1.setDegree("Undergraduate");
    u1.show();

    Undergraduate u2=new Undergraduate("王五",5,"Undergraduate");//有参构造
    u2.show();
  }
}
