/*
 * @Author: Weidows
 * @Date: 2020-07-22 18:51:49
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-24 19:26:55
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\field\Location.java
 */
package twenty.july.control_inversion.field;

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