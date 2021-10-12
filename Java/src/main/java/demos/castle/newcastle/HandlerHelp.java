/*
 * @Author: Weidows
 * @Date: 2020-07-08 22:41:28
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:18:22
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\design_principle\newcastle\HandlerHelp.java
 */
package demos.castle.newcastle;

public class HandlerHelp extends Handler {
  public HandlerHelp(Game game) {
    super(game);
  }

  @Override
  public void doCmd(String word) {
    System.out.println("迷路了吗?你可以做的命令有:go,bye,help\t如:go east");
  }
}
