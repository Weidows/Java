/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-02-11 18:01:50
 * @LastEditors: Weidows
 * @LastEditTime: 2021-02-19 17:23:43
 * @FilePath: \Weidows\Java\src\main\java\twenty\november\proxy\static_proxy\StaticProxy.java
 * @Description:
 * @!: *********************************************************************
 */

package twenty.november.proxy.static_proxy;

// ! 测试类
public class StaticProxy {
  public static void main(String[] args) {
    MarryProxy proxy = new MarryProxy(new Me("Weidows"));
    proxy.Marry();
  }
}

/**
 * ! 代理和被代理类都实现Marry接口
 * 抽象性事件
 */
interface Marry {
  void Marry();
}

/**
 * ! 被代理者
 */
class Me implements Marry {
  public String name;

  @Override
  public void Marry() {
    System.out.println(name + "结婚了");
  }

  public Me(String name) {
    this.name = name;
  }

}

/**
 * ! 代理
 */
class MarryProxy implements Marry {
  private Me target;

  @Override
  public void Marry() {
    before();
    target.Marry();
    after();
  }

  private void after() {
    System.out.println(target.name + "结婚后");
  }

  private void before() {
    System.out.println(target.name + "结婚前");
  }

  public MarryProxy(Me target) {
    this.target = target;
  }

}
