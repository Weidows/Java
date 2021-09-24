<!--
 * @Author: Weidows
 * @Date: 2020-09-11 23:17:51
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-12 10:59:04
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jvm_model\README.md
-->
# JVM内存模型
  ## `堆heap`:
  所有的对象(包括定义的对象和字符串对象)
  ## `栈stack`:
  基础数据类型,以及对象的引用(对象在堆内部的地址)
  ## `方法区method`:
  所有的class和static变量

# e.g.
  Person p = new Person();
  栈里面存的就是p,这个p指向堆里面new Person()出来的那个对象地址
  

# `! 重点`
## 在 Student stu = new Student(); 过程中,子类对象的实例化过程:
  - `方法区`:
    1.先加载Person.class,然后是Student.class  (先父类后子类)
  - `堆内存`:
    3.开辟对象空间,分配地址
    4.在对象空间对对象的属性(包括父类的属性)进行默认初始化
    6.显示初始化父类属性
    8.显示初始化子类属性
  - `栈内存`:
    2.申请空间,声明变量stu
    5.子类构造函数方法进栈
    7.父类构造方法进栈,执行后出栈
    9.初始化完毕后,将堆内存中的地址赋给引用变量,子类构造方法出栈


# Java引用变量有两个类型:`编译时类型` && `运行时类型`
  - 编译时类型有声明该变量是使用的类型决定
  - 运行时类型由实际赋给该变量的对象决定
  - 如果二者类型不一致,就出现(对象的)多态
    - 子类的对象可以替代父类的对象使用
    - 一个引用类型变量可以指向不同类型的对象
  - 成员变量:不具备多态性,只看引用变量所属的类(其指向的堆内的具体对象)是否存在该成员

# 虚拟方法调用 e.g.
  ```
  Person e = new Student();
  e.getInfo();
  ```
  - 编译时e为Person类型,调用时是用的Student类的(动态绑定)