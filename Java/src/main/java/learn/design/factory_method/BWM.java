/*
 * @Author: Weidows
 * @Date: 2020-10-17 00:20:17
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-19 15:10:25
 * @FilePath: \Weidows\Java\src\main\java\design\factory_method\BWM.java
 */
package learn.design.factory_method;

/**
 * 宝马的产品接口
 */
public interface BWM {
  void showInfo();
}

class BWM3 implements BWM {
  @Override
  public void showInfo() {
    System.out.println("这个是宝马三系车");
  }
}

class BWM5 implements BWM {
  @Override
  public void showInfo() {
    System.out.println("这个是宝马五系车");
  }
}

class BWM7 implements BWM {
  @Override
  public void showInfo() {
    System.out.println("这个是宝马七系车");
  }
}
