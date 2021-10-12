/*
 * @Author: Weidows
 * @Date: 2020-07-08 08:31:52
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 21:20:07
 * @FilePath: \Weidows\Java\src\main\java\design\design_principle\newcastle\Room.java
 */
package demos.castle.newcastle;

public class Room {
  /*
      public String description;
      public Room northExit;
      public Room southExit;
      public Room eastExit;
      public Room westExit;
  *///统统私有化,降低类间的耦合
  private String description;
  private Room northExit;
  private Room southExit;
  private Room eastExit;
  private Room westExit;

  public Room(String description) {
    this.description = description;
  }

  public void setExits(Room north, Room east, Room south, Room west) {
    if (north != null)
      northExit = north;
    if (east != null)
      eastExit = east;
    if (south != null)
      southExit = south;
    if (west != null)
      westExit = west;
  }

  public String getExitDescription() {
    //方案一
    /*
    String ret = "";
    if (northExit != null)
    ret += "north";
    if (eastExit != null)
    ret += "east";
    if (westExit != null)
    ret += "west";
    if (southExit != null)
    ret += "south";
    return ret;
    */

    /**
     * 一般不会用String这样+++字符串,系统资源开销大
     * 返回字符串应是方向,而不是northExit(之类的)对象的内容
     * String这种类的对象无法修改...每次+=实际上是产生一个新的对象
     *
     * #重要# 当需要产生一个可修改的字符串时StringBuffer更好
     *
     *
     */

    //方案二(优化)
    StringBuffer sb = new StringBuffer();
    String separation = " ";
    if (northExit != null)
      sb.append("north" + separation);
    if (eastExit != null)
      sb.append("east" + separation);
    if (westExit != null)
      sb.append("west" + separation);
    if (southExit != null)
      sb.append("south" + separation);
    return sb.toString();
    /**这里.append()直接把字符串连起来,中间没有分隔,需要自行调整
     * 返回值是字符串而不是直接print,便于代码维护和拓展 */
  }

  public Room getExit(String direction) {
    Room ret = null; //记得要初始化
    if (direction.equals("north"))
      ret = northExit;
    if (direction.equals("east"))
      ret = eastExit;
    if (direction.equals("west"))
      ret = westExit;
    if (direction.equals("south"))
      ret = southExit;

    return ret;
  }

  @Override
  public String toString() {
    return this.description;
  }

  public static void main(String[] args) {

  }
}
