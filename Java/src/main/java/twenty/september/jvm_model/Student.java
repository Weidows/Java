/*
 * @Author: Weidows
 * @Date: 2020-09-12 10:23:27
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-12 10:28:04
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jvm_model\Student.java
 */
package twenty.september.jvm_model;

public class Student extends Person {
  String school;

  public Student() {
    /**
     * 因为父类并不是Student构造器,这里用super()调用父类中的构造器,此处只是没有传递参数
     * 不能算overwrite
     */
    super();
  }
}
