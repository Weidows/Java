/*
 * @Author: Weidows
 * @Date: 2020-07-08 08:30:19
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:54:44
 * @FilePath: \Java\Java\src\main\java\demos\castle\newcastle\Game.java
 *
 *
 * 代码类与类之间耦合(关联性)越低越好,接口越少越好->封装
 * 有效方法是所有成员变量尽可能的私有(private)
 */
package demos.castle.newcastle;

import java.util.HashMap;
import java.util.Scanner;

public class Game {
  private Room currentRoom;
  /**
   * 做一个HashMap,保存String与Handler函数间的关系,实际上是需要保存String对象与函数间的关系,但是由于HashMap只能接收对象,所以把函数在Handler类中体现
   */
  private HashMap<String, Handler> handlers = new HashMap<String, Handler>();

  public Game() {
    createRooms();
    //把功能函数做成Handler的子类
    handlers.put("go", new HandlerGo(this));
    handlers.put("bye", new HandlerBye(this));
    handlers.put("help", new HandlerHelp(this));
  }

  private void createRooms() {
    /**
     * 虽然可以直接把此函数做成构造函数,但考虑封装..还是让构造函数调用此函数比较好
     */
    //初始化房间
    Room outside = new Room("城堡外");
    Room lobby = new Room("大堂");
    Room pub = new Room("酒吧");
    Room study = new Room("书房");
    Room bedroom = new Room("卧室");
    currentRoom = outside; //从城堡门外开始
    //初始化房间出口
    outside.setExits(null, lobby, study, pub);
    lobby.setExits(null, null, null, outside);
    pub.setExits(null, outside, null, null);
    study.setExits(outside, bedroom, null, null);
    bedroom.setExits(null, null, null, study);
  }

  private void printWelcome() {
    System.out.println("\n欢迎来到城堡!\n这是一个超级无聊的游戏.\n如果需要帮助,请输入'help'.\n");
    this.location();
  }

  private void location() {
    System.out.print("现在你在" + currentRoom + "\t出口有:");
    // 判断出口(不良代码,冗余,降低耦合已优化)
    /*
    if (currentRoom.northExit != null)
        System.out.print("north\t");
    if (currentRoom.southExit != null)
        System.out.print("south\t");
    if (currentRoom.westExit != null)
        System.out.print("west\t");
    if (currentRoom.eastExit != null)
        System.out.print("east\t");
    System.out.println();
    */
    System.out.println(currentRoom.getExitDescription());
  }

  void goRoom(String direction) {
    // Room nextRoom = null;
    if (direction.equals("north") || direction.equals("south") || direction.equals("east")
        || direction.equals("west")) {
      /*
      if (direction.equals("north"))
          currentRoom = currentRoom.northExit;
      if (direction.equals("east"))
          currentRoom = currentRoom.eastExit;
      if (direction.equals("west"))
          currentRoom = currentRoom.westExit;
      if (direction.equals("south"))
          currentRoom = currentRoom.southExit;
      */
      currentRoom = currentRoom.getExit(direction);
    } else
      System.out.println("那里没有门!");
    this.location();
  }

  private void play() {
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.print("输入动作:");
      // 短语分词(好方法)
      String line = in.nextLine();
      // 根据空格把line分成数组
      String[] words = line.split(" ");
      //把由String关联的那个类所创建的对象让handler管理
      Handler handler = handlers.get(words[0]);

      if (handler != null) {
        if (handler.isBye()) {
          in.close();
          break;
        }
        //保险措施
        String value = "";
        if (words.length > 1)
          value = words[1];
        handler.doCmd(value);
        /**
         * 像是help和bye的.doCmd函数没有自定义为空,不会产生影响
         */
      } else
        System.out.println("输入错误.");

      /*
          if (words[0].equals("help"))
              this.printHelp();
          else if (words[0].equals("go"))
              this.goRoom(words[1]);
          else if (words[0].equals("bye")) {

              in.close();
              break;
          } else
              System.out.println("输入错误!请重新输入.");
      */
    }

  }

  public static void main(String[] args) {
    Game game = new Game();
    game.printWelcome();
    game.play();
  }
}
