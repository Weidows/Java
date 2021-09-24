/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:00
 * @LastEditors: Weidows
 * @LastEditTime: 2020-07-25 11:34:02
 * @FilePath: \Weidows\Java\src\main\java\twenty\july\control_inversion\field\Field.java
 */
package twenty.july.control_inversion.field;

import java.util.ArrayList;

import twenty.july.control_inversion.cell.Cell;

public class Field {
  private int width;
  private int height;
  private Cell[][] cells;
  private static final Location[] adjacent = {
    new Location(-1, -1), new Location(-1, 0), new Location(-1, 1),
    new Location(0, -1), new Location(0, 0), new Location(0, 1),
    new Location(1, -1), new Location(1, 0), new Location(1, 1), 
  };

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    cells = new Cell[height][width];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void place(int row, int col, Cell cell) {
    cells[row][col] = cell;
  }

  public Cell get(int row, int col) {
    return cells[row][col];
  }

  public Cell[] getNeighbor(int row, int col) {
    ArrayList<Cell> list = new ArrayList<Cell>();
    for (Location loc : adjacent) {
      int r = row + loc.getRow();
      int c = col + loc.getCol();
      if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) list.add(cells[r][c]);
    }
    return list.toArray(new Cell[list.size()]);
  }

  public Location[] getFreeNeighbor(int row, int col) {
    ArrayList<Location> list = new ArrayList<Location>();
    for (Location loc : adjacent) {
      int r = row + loc.getRow();
      int c = col + loc.getCol();
      if (r > -1 && r < height && c > -1 && c < width && cells[r][c] == null) {
        list.add(new Location(r, c));
      }
    }
    return list.toArray(new Location[list.size()]);
  }

  public boolean placeRandomAdj(int row, int col, Cell cell) {
    boolean ret = false;
    Location[] freeAdj = getFreeNeighbor(row, col);
    if (freeAdj.length > 0) {
      int idx = (int) (Math.random() * freeAdj.length);
      cells[freeAdj[idx].getRow()][freeAdj[idx].getCol()] = cell;
      ret = true;
    }
    return ret;
  }
  public void remove(Cell fed) {
    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        if (cells[row][col] == fed) {
          cells[row][col] = null;
          break;
        }
      }
    }
  }

  public void remove(int row, int col) {
    cells[row][col] = null;
  }

  public void move(int row, int col, Location loc) {
    cells[loc.getRow()][loc.getCol()] = cells[row][col];
    remove(row, col);
  }
}