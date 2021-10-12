/*
 * @Author: Weidows
 * @Date: 2020-10-17 00:30:39
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-19 22:18:12
 * @FilePath: \Weidows\Java\src\main\java\design\factory_method\BWMFactory.java
 */
package learn.design.factory_method;

/**
 * 汽车生产工厂接口
 */
public interface BWMFactory {
  BWM produceBWM();
}

/**
 * ! 实现具体的车型生产工厂类
 */
class BWM3Factory implements BWMFactory {
  @Override
  public BWM produceBWM() {
    System.out.println("生产宝马三系车");
    return new BWM3();
  }
}

class BWM5Factory implements BWMFactory {
  @Override
  public BWM produceBWM() {
    System.out.println("生产宝马五系车");
    return new BWM5();
  }
}

class BWM7Factory implements BWMFactory {
  @Override
  public BWM produceBWM() {
    System.out.println("生产宝马七系车");
    return new BWM7();
  }
}
