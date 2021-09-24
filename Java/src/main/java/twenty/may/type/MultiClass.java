package twenty.may.type;

/*
 * @Author: Weidows
 * @Date: 2020-05-29 01:04:16
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 15:10:52
 * @FilePath: \Weidows\Java\src\main\java\twenty\May\type\MultiClass.java
 */ 
/* 1.关于java类的解释
 * 一个.java源文件中可以有多个类吗？（内部类除外）有什么条件？ 
 * 可以的   
 *但是只能有一个public类, 而且如果有public类的话，这个文件的名字要和这个类的名字一样。
 *如果都没有public类，名字可以不和这个类一样。
 */

public class MultiClass {
    int i = 0;
}

class B {
    String str = "b";
}

class C {
    String str = "c";
}
/*
 * 源文件javac出多个class文件出来!是怎么回事? 
 * 1. 你在一个文件里定义了几个类的时候，会出现这种情况，比如 
 * public class A {} class B {} class C {} 这样每个 class 会是一个 .class 文件
 * 2. 你定义了内部类的时候会出现这种情况，如 public class A { class B { } } 这会产生两个 class 文件
 * 3. 使用了匿名类的时候出出现这种情况，如 public class A { void xxx() {
 * button.addActionLisener(new ActionListener() {...}); } } 这也会产生多个 class，一个A.class，一个 A$1.class }
 */
