/*
 * @Author: Weidows
 * @Date: 2020-07-08 08:30:19
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:54:16
 * @FilePath: \Java\Java\src\main\java\demos\castle\castle\Game.java
 */
package demos.castle.castle;

import java.util.Scanner;

public class Game {
  private Room currentRoom;

  public Game() {
    createRooms();
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

  private void printHelp() {
    System.out.println("迷路了吗?你可以做的命令有:go,bye,help");
    System.out.println("如:go east");
  }

  private void location() {
    System.out.print("现在你在" + currentRoom + "出口有:");
    // 判断出口
    if (currentRoom.northExit != null)
      System.out.print("north\t");
    if (currentRoom.southExit != null)
      System.out.print("south\t");
    if (currentRoom.westExit != null)
      System.out.print("west\t");
    if (currentRoom.eastExit != null)
      System.out.print("east\t");
    System.out.println();
  }

  private void goRoom(String direction) {
    // Room nextRoom = null;
    if (direction.equals("north") || direction.equals("south") || direction.equals("east")
        || direction.equals("west")) {
      if (direction.equals("north"))
        currentRoom = currentRoom.northExit;
      if (direction.equals("east"))
        currentRoom = currentRoom.eastExit;
      if (direction.equals("west"))
        currentRoom = currentRoom.westExit;
      if (direction.equals("south"))
        currentRoom = currentRoom.southExit;
    } else
      System.out.println("那里没有门!");
    this.location();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Game game = new Game();
    game.printWelcome();

    while (true) {
      System.out.print("输入动作:");
      //短语分词(好方法)
      String line = in.nextLine();
      //根据空格把line分成数组
      String[] words = line.split(" ");
      if (words[0].equals("help"))
        game.printHelp();
      else if (words[0].equals("go"))
        game.goRoom(words[1]);
      else if (words[0].equals("bye")) {
        System.out.println("感谢您的光临,再见!");
        in.close();
        break;
      } else
        System.out.println("输入错误!请重新输入.");
    }
  }
}
