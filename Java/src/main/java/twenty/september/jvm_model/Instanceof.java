/*
 * @Author: Weidows
 * @Date: 2020-09-12 13:10:29
 * @LastEditors: Weidows
 * @LastEditTime: 2020-12-18 22:59:55
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jvm_model\Instanceof.java
 */

package twenty.september.jvm_model;

public class Instanceof {
  public static void main(String[] args) {
    /**
     * instanceof操作符,判断对象是否由某个类(或子类,不能是父类)实例化
     */
    Student s = new Student();
    Person p = new Person();

    //正常判断
    System.out.println(s instanceof Student); //true
    System.out.println(p instanceof Person); //true

    //s由Student实例化,Student是Person的子类,没问题.
    System.out.println(s instanceof Person); //true
    //Person是Student的父类,不对劲.
    System.out.println(p instanceof Student); //false

    String s1 = "abc", s2 = "abc", s3 = new String("abc");
    System.out.println("s1的数据与s2是否相等:" + s1.equals(s2)); //true
    System.out.println("s1与s2是否是同一个对象:" + (s1 == s2)); //true
    System.out.println("s1与s3是否是同一个对象:" + (s1 == s3)); //false
    /**
     * 这三个数据一模一样,所以随意两个之间.equals()肯定是true
     * s1和s2中的字符串都是常量池中的,可以视为同一个对象,所以第二句是true
     * s3在堆内存开辟了一个对象"abc",s3在栈中引用它,所以第三句,他俩并不是同一个对象,是false
     *
     * .equals()只对String类特殊照顾:判断字符串数据是否相同
     * 对于其他类,.equals()与"=="一模一样:判断是否是同一个对象
     *
     * .equals()判断的是对象在堆内存中是否是同一数据
     * 创造对象时每new一次会在堆内存创建新对象数据
     * 而像是Person pr = pp这种是栈数据的复制,所指对象相同
     */
    Person pp = new Person(), pe = new Person();
    Person pr = pp;
    System.out.println("pp是否与pe是否是同一个对象:" + pp.equals(pe)); // false
    System.out.println("pp是否与pr是否是同一个对象:" + pp.equals(pr)); // true
  }
}
