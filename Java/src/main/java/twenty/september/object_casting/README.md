<!--
 * @Author: Weidows
 * @Date: 2020-09-19 09:53:42
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-19 11:42:36
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\object_casting\README.md
-->

# 对象类型转换(造型)

- 子类到父类的转换可以自动进行
- 父类到子类的转换需要进行造型 Casting
- 无继承关系的引用类型间的转换是非法的

# ==操作符与.equals()

- ==操作符两边数据类型必须兼容(是否有继承关系)
  - 可以比较基本类型数据 && 引用类型数据(是否指向同一对象)
- equals()只能比较引用类型数据,比较是否指向同一对象
  - 特殊情况: File,String,Data 及包装类来说,是比较其实际内容

# String 对象的创建

- 字面量方法比 new 省内存
