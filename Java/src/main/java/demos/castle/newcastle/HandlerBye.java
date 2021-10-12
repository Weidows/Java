/*
 * @Author: Weidows
 * @Date: 2020-07-08 19:17:05
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-08 23:31:55
 * @FilePath: \Weidows\src\twenty\july\f设计原则\newcastle\HandlerBye.java
 */
package demos.castle.newcastle;

public class HandlerBye extends Handler {
  public HandlerBye(Game game) {
    super(game);
  }

  @Override
  public boolean isBye() {
    System.out.println("感谢您的光临,再见!");
    return true;
  }
}
