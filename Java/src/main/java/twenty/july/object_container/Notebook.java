/*
 * @Author: Weidows
 * @Date: 2020-07-03 10:09:58
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:12:21
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\object_container\Notebook.java
 * 
 * 
 * 对象容器
 */
package twenty.july.object_container;

import java.util.ArrayList;
import java.util.HashSet;

public class Notebook {
  // 用容器类在Notebook类内创建一个private成员对象notes
  private ArrayList<String> notes = new ArrayList<String>();
  /* 读作ArrayList all String ,叫做范型类(容器类)
   * 容器类有两个类型:容器的类型 && 元素的类型
   * 1.ArrayList就是容器的类型(还有其他容器类)
   * 2.<>里面的就是这个容器notes唯一存储的类型(元素的类型)
   * 3.如果去掉<String>则容器可容纳任意类型数据,比如ArrayList list=new ArrrayList()*/
  private HashSet<String> notes_1 = new HashSet<String>();

  /**
   * HashSet这个容器与ArrayList类似,不同是其不能重复装相同数据,且数据无序
   * 既然他是无序的,那么就无法使用index定位数据
   */

  public void add(String s) {
    notes.add(s);
    notes_1.add(s);
    // notes.add(10); Java这里区分int和插入,不能接收数字
  }

  public void add(String s, int location) {
    notes.add(location, s);
    /* 上一个以及这个成员函数中用到的add是容器类带给notes的 */
  }

  public int getSize() {
    return notes.size();/* 类带的成员函数 */
  }

  public String getNote(int index) {
    return notes.get(index);
  }

  public void removeNote(int index) {
    notes.remove(index);
  }

  public String[] list() {/* 把容器内数据变成数组并返回 */
    String[] a = new String[notes.size()];
    /*
    for (int i = 0; i < notes.size(); i++) {
        a[i] = notes.get(i);
    }  把容器传递给字符串数组a
    */
    notes.toArray(a);/* 使用库的方法,直接能把容器传递给array */
    return a;
  }

  public void printString() {
    /**
     * 容器可以以[A,B]的形式直接输出,print可以识别(重要)
     * 但是不能直接输出对象,print不识别,会输出所引用对象的堆地址
     */
    System.out.print("\nArrayList:" + this.notes + "\t");
    System.out.println("HashSet:" + this.notes_1);
  }

  public String toString() {
    /**
     * public String toString()这个成员函数就是控制输出对象时的内容
     * 比如容器类就会带有这么个函数,于是print可以直接输出容器
     * 类似函数带回的返回值,这个是输出对象时print默认去找的函数
     * 没有自定义这个的类new出来的对象输出时不会报错但会出来奇怪的结果
     */
    return "HelloWorld!";
  }

  public static void main(String[] args) {
    Notebook nb = new Notebook();/* new对象nb,内含一个容器类 */
    nb.add("first");
    nb.add("second");
    nb.add("second");/* 装重复数据HashSet不会报错 */
    System.out.println(nb.getSize() + "\t" + nb.getNote(1));

    String[] a = nb.list();/* 把容器传递给字符串数组 */
    for (String s : a) {
      System.out.print(s + "\t");
    }
    nb.printString();/* 调用容器输出函数 */
    System.out.println(nb);
  }
}
