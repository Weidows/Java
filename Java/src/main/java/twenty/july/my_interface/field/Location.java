/*
 * @Author: Weidows
 * @Date: 2020-07-22 18:51:49
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 17:39:16
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\my_interface\field\Location.java
 */
package twenty.july.my_interface.field;

public class Location {
  private int row;
  private int col;

  public Location(int row, int col) {
    this.row = row;
    this.col = col;
  }

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }
}