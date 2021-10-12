/*
 * @Author: Weidows
 * @Date: 2020-07-08 18:58:48
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:19:34
 * @FilePath: \Weidows\Java\src\main\java\design\design_principle\newcastle\Handler.java
 */
package demos.castle.newcastle;

public class Handler {
  protected Game game;

  public Handler(Game game) {
    this.game = game;
  }

  public void doCmd(String word) {
  }

  public boolean isBye() {
    return false;
  }
}
