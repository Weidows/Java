/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-27 17:21:06
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-27 17:26:11
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\reflection\Demo5.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.reflection;

public class Demo5 {
  public static void main(String[] args) throws ClassNotFoundException {
    //获取系统的类加载器
    ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    System.out.println(systemClassLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@4459eb14

    //获取系统类加载器的父类加载器-->扩展类加载器
    ClassLoader parent = systemClassLoader.getParent();
    System.out.println(parent);//jdk.internal.loader.ClassLoaders$PlatformClassLoader@7960847b

    //获取扩展类加载器的父类加载器-->根加载器(C/C++)
    ClassLoader grantparent = parent.getParent();
    System.out.println(grantparent);//null

    //测试当前类是哪个加载器加载的
    ClassLoader classLoader = Demo5.class.getClassLoader();
    System.out.println(classLoader);//jdk.internal.loader.ClassLoaders$AppClassLoader@4459eb14

    //测试JDK内置的类是谁加载的
    ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
    System.out.println(classLoader1);//null

    //如何获得系统类加载器可以加载的路径
    System.out.println(System.getProperty("java.class.path"));//D:\Game\Weidows\Java\target\classes;D:\Game\Scoop\persist\maven\mvn-repository\commons-io\commons-io\2.8.0\commons-io-2.8.0.jar
  }
}
