/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-27 18:14:58
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-27 18:30:58
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo6.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo6 {

  public static void main(String[] args) throws Exception {
    //获得class对象
    Class c1 = User.class;

    //创建一个对象
    User user = (User) c1.newInstance();//本质是调用了类的无参构造器
    System.out.println(user);

    //通过构造器创建对象
    System.out.println("============================");
    Constructor constructor = c1.getDeclaredConstructor(String.class, int.class);
    User user2 = (User) constructor.newInstance("打爆", 22);
    System.out.println(user2);

    //通过反射获取一个方法
    System.out.println("============================");
    Method setName = c1.getDeclaredMethod("setName", String.class);
    /**
     * invoke: 激活
     * invoke(执行方法的对象+原方法的参数1+原方法的参数2+...)
     */
    setName.invoke(user, "Weidows");
    System.out.println(user.getName());

    //通过反射操作属性
    System.out.println("============================");
    User user3 = (User) c1.newInstance();
    Field name = c1.getDeclaredField("name");
    //不能直接操作私有属性，我们需要关闭程序的安全监测，属性或方法的setAccessible(true)
    name.setAccessible(true);
    name.set(user3, "齐下无贰");
    System.out.println(user3.getName());

    /**
      twenty_one.reflection.User@59f95c5d
      ============================
      twenty_one.reflection.User@5c8da962
      ============================
      Weidows
      ============================
      齐下无贰
     */
  }
}

class User {
  private String name;
  private int age;

  public User() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }
}
