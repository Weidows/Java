/*
 * @Author: Weidows
 * @Date: 2020-07-08 19:00:21
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-18 16:23:38
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\design_principle\newcastle\HandlerGo.java
 */
package demos.castle.newcastle;

public class HandlerGo extends Handler {
  public HandlerGo(Game game) {
    super(game);
  }

  public void doCmd(String word) {
    game.goRoom(word);
  }
}
