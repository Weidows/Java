/*
 * @Author: Weidows
 * @Date: 2020-09-19 09:58:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-19 13:40:42
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\object_casting\Person.java
 */
package twenty.september.object_casting;

public class Person {
  public static void main(String[] args) {
    //父类在栈中的引用变量指向子类new出来的对象数据,木的问题,子类自动转父类
    Person p = new Student();
    //子类的引用变量接收父类的对象数据需要Casting
    Student s = (Student) p;
    s.toString(); //瞎报警,让它老实一下

    Person p1 = new Person();
    Person p2 = new Person();
    Person p3 = p1;
    System.out.println("p1与p2是否指向同一对象: " + (p1 == p2)+
      "\np1与p2是否指向同一对象: " + (p1 == p3));
  }
}
