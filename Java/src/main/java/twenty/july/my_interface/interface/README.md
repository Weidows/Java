<!--
 * @Author: Weidows
 * @Date: 2020-10-20 20:50:57
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:01:44
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\my_interface\interface\README.md
-->

oop 语言都无法进行多继承(继承复数个类)
特例是 C++,其只能算半 oop 语言,特殊能够进行多继承

接口 interface
本质是纯抽象类(但实际与类地位相同)
? extends 是类的继承(oop 只能继承一个父类)
? implements 是某个类实现了某个接口(接口可以有多个)
! 接口可以继承接口,但不能继承类,接口也不能实现接口
_ 所有的成员函数都是抽象函数
_ 所有成员变量都是 public static final(不用去写,自带)
接口规定长了什么样子,不管里面有什么

面向接口编程
? 设计程序时先定义接口再实现类
程序间传入传出的是接口而不是类
