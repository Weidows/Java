/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-28 14:34:20
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:03:25
 * @FilePath: \Java\Java\src\main\java\learn\reflection\Annotation.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Annotation {
  public static void main(String[] args) throws NoSuchFieldException, SecurityException {
    // * 通过反射获取注解
    java.lang.annotation.Annotation[] annotations = Student1.class.getAnnotations();
    for (java.lang.annotation.Annotation annotation : annotations) {
      System.out.println(annotation);
    }

    // * 获取注解的value
    Table annotation = Student1.class.getAnnotation(Table.class); //获取Student1类上Table类型的注解
    System.out.println(annotation.value());

    // * 获取指定的value
    java.lang.reflect.Field f = Student1.class.getDeclaredField("name");
    Field annotation1 = f.getAnnotation(Field.class);
    System.out.println(annotation1.columnName() + "\t" + annotation1.type() + "\t" + annotation1.length());
  }
  /**
    @twenty_one.reflection.Table(value="db_student")
    db_student
    db_name varchar 3
   */
}

@Table(value = "db_student")
class Student1 {
  @Field(columnName = "db_id", type = "int", length = 10)
  private int id;
  @Field(columnName = "db_age", type = "int", length = 10)
  private int age;
  @Field(columnName = "db_name", type = "varchar", length = 3)
  private String name;

  public Student1() {
  }

  public Student1(int id, int age, String name) {
    this.id = id;
    this.age = age;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Student [age=" + age + ", id=" + id + ", name=" + name + "]";
  }
}

// ! 类名的注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Table {
  String value();
}

// ! 属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Field {
  String columnName();

  String type();

  int length();
}
