/*
 * @Author: Weidows
 * @Date: 2020-07-12 15:17:00
 * @LastEditors: Weidows
 * @LastEditTime: 2020-10-20 17:49:03
 * @FilePath: \Weidows\Java\src\main\java\design\mvc_pattern\data_depart_behave\field\Field.java
 */
package learn.design.mvc_pattern.data_depart_behave.field;

import java.util.ArrayList;

import learn.design.mvc_pattern.data_depart_behave.cell.Cell;

public class Field {
  private int width;
  private int height;
  private Cell[][] field;//声明有这么个数组变量,但未承接任何对象

  public Field(int width, int height) {
    this.width = width;
    this.height = height;
    field = new Cell[height][width];
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public Cell place(int row, int col, Cell o) {
    Cell ret = field[row][col];
    field[row][col] = o;
    return ret;
  }

  public Cell get(int row, int col) {
    return field[row][col];
  }

  /**
   * *在这里之所以返回的是Cell[]而不是直接返回数量或者直接让Cell返回是为了增强可拓展性
   * *便于以后功能增加
   */
  public Cell[] getNeighbor(int row, int col) {
    ArrayList<Cell> list = new ArrayList<Cell>();
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        int r = row + i;
        int c = col + j;
        if (r > -1 && r < height && c > -1 && c < width && !(r == row && c == col)) {
          list.add(field[r][c]);
        }
      }
    }
    return list.toArray(new Cell[list.size()]);
    //?学着点:把ArrayList转成数组(需要new对应类型的数组对象并给出大小)
  }

  //清除field单位上的对象
  public void clear() {
    for (int i = 0; i < height; i++) {
      for (int j = 0; j < width; j++) {
        field[i][j] = null;
      }
    }
  }
}
