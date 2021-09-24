/*
 * @Author: Weidows
 * @Date: 2020-06-01 00:04:03
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 20:46:56
 * @FilePath: \Weidows\Java\src\main\java\twenty\june\string_package\Test.java
 * 
 * 
 * 字符串&&包裹类型
 */
package twenty.june.string_package;

public class Test {
  public static void main(String[] args) {
    //? java中math函数调用类似C语言
    System.out.println(
        "一:" + Math.abs(-12) + " \t" + Math.round(10.645) + "\t" + Math.random() * 100 + "\t" + Math.pow(2, 3));
        
    String s = "Hello World";
    String s_1 = new String("Hello World"); //两种创建方式
    System.out.println("二:" + s + "\t" + s_1);
    /**
     * 字符串的创建,String首字母大写表明其实一个类,创建一个 String类的对象s,
     * 而且s这个对象是Hello World的管理者而非所有者
     * String这个类可以用+连接,例:"Hello"+"World"="HelloWorld"
     * 另外,java中字符串概念相同于C语言中的指针,其本身是一个地址所以s==s_1必是false
     * 需要对内容本身进行操作时需要用对象的方法 
     */

    //? 字符串的一些方法
    //equals判断内容是否相同,字符串的length与数组不同,需要在后面加个括号
    System.out.println("三:" + s.equals(s_1) + "\t" + s.length());
    //字符读取_1    charAt( int index)
    System.out.print("四:");
    for (int i = 0; i < s.length(); i++)
      System.out.print(s.charAt(i)); //注意是从0~(n-1)
    System.out.println();

    //字符读取_2    substring(int beginIndex,int endIndex )
    System.out.print("substring:  " + s.substring(2) + "\t");
    System.out.println(s.substring(2, 4)); //注意是从2开始到4之前->23

    //查找字符串    indexOf()
    System.out.print(s.indexOf('e') + "\t"); //找单个字符,找不到返回-1
    System.out.print(s.indexOf("llo") + "\t"); //字符串输出是首字母位置

    //小实例:找到无限长字符串中某个字符所有位置并输出
    char findChar = 'o';
    int loc = s.indexOf(findChar);
    while (loc != -1) {
      System.out.print(loc + "\t");
      loc = s.indexOf(findChar, loc + 1); //从loc+1的位置再开始找
    }
    /* 输入类型
        int a = in.nextInt();
        double b = in.nextDouble();
        String c = in.next();   //读下一个单词,直到(空格,Tab,换行)
        String c_1 = in.nextLine(); //读下一整行 */
  }
}
