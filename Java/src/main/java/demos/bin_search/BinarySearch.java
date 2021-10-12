/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-10-12 13:06:38
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 13:55:54
 * @FilePath: \Java\Java\src\main\java\demos\bin_search\BinarySearch.java
 * @Description:
 *
 * 二分搜索个人提交作业:
 * 给定 0~4095 已排序的整数到数组中,分别求查找 -1, 1024, 3000, 4096 查询次数
 *
 * 解答:
      Search failed: -1 times: 12
      Search success: 1024 times: 12
      Search success: 3000 times: 12
      Search failed: 4096 times: 13
 * @!: *********************************************************************
 */
package demos.bin_search;

public class BinarySearch {

  static int searchTimes;

  public static void main(String[] args) {
    getSearchTimes(4096, -1);
    getSearchTimes(4096, 1024);
    getSearchTimes(4096, 3000);
    getSearchTimes(4096, 4096);
  }

  static int binarySearch(int array[], int x) {
    searchTimes = 0;
    int left = 0;
    int right = array.length - 1;
    int middle;

    while (left <= right) {
      searchTimes++;
      middle = (left + right) / 2;

      if (x == array[middle])
        return middle;

      if (x > array[middle])
        left = middle + 1;
      else
        right = middle - 1;
    }
    return -1; //未找到x
  }

  static void getSearchTimes(int n, int x) {
    int[] array = new int[n];
    for (int index = 0; index < array.length; index++) {
      array[index] = index;
    }

    if (binarySearch(array, x) == -1) {
      System.out.println("Search failed: " + x + " times: " + searchTimes);
    } else
      System.out.println("Search success: " + x + " times: " + searchTimes);
  }
}
