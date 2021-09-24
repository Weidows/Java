/*
 * @Author: Weidows
 * @Date: 2020-10-26 22:41:10
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-26 23:20:05
 * @FilePath: \Weidows\Java\src\main\java\twenty\october\enumerate\Season.java
 */
package twenty.october.enumerate;

public enum Season implements Interfaces {
  /**
   * / 枚举实例化
   * ! <p>枚举全字母大写格式
   * <p>这里相当于调用构造体,每个枚举是一个成员对象变量
   *  <p> 类名.枚举相当于用(已经定义过的特殊构造器)来实例化一个对象并返回(而且是单例模式,返回的所有引用指向同一个实际对象)
   */
  SPRING("春天", "这是春天"),

  SUMMER("夏天", "这是夏天"),

  AUTUMN("秋天", "这是秋天"),

  WINTER("冬天", "这是冬天");

  /**
   * / 定义枚举内部元素
   */
  private final String name;
  private final String desc;

  private Season(String name, String desc) {
    this.name = name;
    this.desc = desc;
  }

  public void showInfo() {
    System.out.println(name + "\t" + desc);
  }

  @Override
  public void test() {
    /**
     *  与类相同,枚举实现的方法也必须通过实例化的对象调用,对象.方法()
     */
    System.out.println("there in Season.test() : void");
  }
}

class Test {
  public static void main(String[] args) {
    Season spring = Season.SPRING;
    spring.test();
  }
}

/**
 * / 测试Enumerate实现接口
 */
interface Interfaces {
  public void test();
}
