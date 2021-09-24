/*
 * @Author: Weidows
 * @Date: 2020-09-12 09:34:09
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-12 09:46:35
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jvm_model\TestTransfer_1.java
 */
package twenty.september.jvm_model;

public class TestTransfer_1 {
  public static void swap(Data d1) {
    d1.a = 6;
    System.out.println("swap方法里,a=" + d1.a);
  }

  public static void main(String[] args) {
    Data data = new Data();
    System.out.println("执行swap()前,main里面a=" + data.a);
    swap(data);
    System.out.println("执行swap后,main里面,a=" + data.a);
  }
}
/**
 * 这里把对象Data传入时也是传入的Data的副本,并非传入其本身
 * 之所以Data和d1都可以修改Data里面的数据是因为d1这个参数与Data都是Data内部数据的管理者
 * 这些"管理者"都存放在栈内存里面,指向堆内存中的实际数据
 * 这种管理方式使得参数传递过程中性能极大提升
 */