/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 10:12:35
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 10:33:53
 * @FilePath: \Weidows\Java\src\main\java\test\five\ListSort.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.five;

import java.util.ArrayList;
import java.util.List;

public class ListSort {

  static void SortByName(List<Person> aList) {
    for (int i = 0; i < aList.size(); i++) {
      for (int j = i + 1; j < aList.size(); j++) {
        if (aList.get(i).firstName.compareTo(aList.get(j).firstName) > 0) {
          Person person1 = aList.get(i);
          Person person2 = aList.get(j);
          Person person3 = new Person(person1.firstName, person1.age);

          person1.firstName = person2.firstName;
          person1.age = person2.age;

          person2.firstName = person3.firstName;
          person2.age = person3.age;
        }
      }
    }
  }

  static void SortByAge(List<Person> aList) {
    for (int i = 0; i < aList.size(); i++) {
      for (int j = i + 1; j < aList.size(); j++) {
        if (aList.get(i).compareByAge(aList.get(j)) == 1) {
          Person person1 = aList.get(i);
          Person person2 = aList.get(j);
          Person person3 = new Person(person1.firstName, person1.age);

          person1.firstName = person2.firstName;
          person1.age = person2.age;

          person2.firstName = person3.firstName;
          person2.age = person3.age;
        }
      }
    }
  }

  public static void main(String[] args) throws Exception {
    // Create a new empty list
    List<Person> people = new ArrayList<>();

    // add some people to the list
    people.add(new Person("John", 67));
    people.add(new Person("Abby", 31));
    people.add(new Person("Catherine", 59));
    people.add(new Person("Amjed", 29));
    people.add(new Person("Bo", 31));
    people.add(new Person("Zac", 67));

    System.out.println(people);
    // SortByName(people);
    System.out.println(people);
    SortByAge(people);
    System.out.println(people);
  }
}
