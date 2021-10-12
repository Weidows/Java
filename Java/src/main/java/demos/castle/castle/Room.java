/*
 * @Author: Weidows
 * @Date: 2020-07-08 08:31:52
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:54:13
 * @FilePath: \Java\Java\src\main\java\demos\castle\castle\Room.java
 */
package demos.castle.castle;

public class Room {
  public String description;
  public Room northExit;
  public Room southExit;
  public Room eastExit;
  public Room westExit;

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

  @Override
  public String toString() {
    return this.description;
  }

  public static void main(String[] args) {

  }
}
