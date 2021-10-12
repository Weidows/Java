/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:10:25
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 10:13:49
 * @FilePath: \Weidows\Java\src\main\java\test\five\Person.java
 * @Description:
 * @!: *********************************************************************
 */

package works.done.poly_technic_university_test.five;

// Person.java, represents a person

public class Person {
  String firstName;
  int age;

  public Person(String firstName, int age) {
    this.firstName = firstName;
    this.age = age;
  }

  public int compareByAge(Person p2) {
    if (this.age > p2.age) {
      return 1;
    } else if (this.age == p2.age) {
      return 0;
    } else {
      return -1;
    }
  }

  public String toString() {
    return (firstName + " " + age);
  }
}
