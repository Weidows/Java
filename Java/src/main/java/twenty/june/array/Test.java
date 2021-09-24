
/*
 * @Author: Weidows
 * @Date: 2020-05-03 01:18:34
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-11 18:32:49
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\array\Test.java
 * 数组
 */
package twenty.june.array;

public class Test {
  public static void main(String[] args) {
    /**
     * 创建数组格式,也可写成 int numbers[] = new int[num];(不建议)
     * 用new创建数组java默认元素赋0值或NULL(重要),
     * 不同于C语言,定义数组前num有确定整数就行,即使不是final类型;
     * numbers[10] = 0; 报错,java会在运行时检查是否越界使用(C语言不检查)
     */
    int num = 10;
    int[] numbers = new int[num];//未初始化,野数组
    int[] scores = { 1, 2, 3, 4, 5, 6, 7 };
    char name = '刘'; //java中char可以是汉字(Unicode编码集支持)

    /**
     * .lengrh是数组大小(自带)
     * 如果直接写成System.out.println(scores.length +name)会输出21023
     * 原因是把char'刘'当做int使用进行加法运算了
     */
    System.out.println(numbers.toString() + "\t" + scores.length + "\t" + name);

    /**
     * 第一种方式一步到位,无法指定数组大小
     * 第二种方式无法一步到位直接传数据,但可以指定大小
     * 
     * 本质上都是String类创建出来的对象(每个元素是一个对象,str和str2是这群对象的管理者)
     * 需要注意通过第二种方法new出来的String数组初始都为NULL,也就是还没有对象,比如调用String类的成员函数比如str2[0].length会出错(无指定对象)
     * 
     * 注意str2.length是String类的成员变量,new对象时自动初始化,而str2[0].length()是字符串长度,需要调用成员函数length()算
     */
    //字符串数组,每个元素是个字符串(内存中非new)
    String[] str = { "a123", "b456" };
    //有十个字符串,但每个字符串长度不定
    String[] str2 = new String[10];
    //类似于一,但内存中是new
    String[] str3 = new String[] { "c123", "d456" };
    
    System.out
        .println("字符串数组大小:" + "\t" + "str:" + str.length + "\t" + "str2:" + str2.length + "\t" + "str3:" + str3.length);
  }
}