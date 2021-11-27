/*
 * @Author: Weidows
 * @Date: 2020-11-27 10:07:22
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-19 17:42:18
 * @FilePath: \Java\Java\src\main\java\demos\sort\QuickSort.java
 * @Description:快速排序(快排)
 */
package demos.sort;

public class QuickSort {
  public static void main(String[] args) {
    // 创建测试数组
    int[] arr = new int[] { 49, 38, 65, 97, 76, 13, 27, 49, 8, 10 };

    // 调用快排接口
    quickSort(arr);
  }

  /**
   * 快速排序
   * @param array
   */
  public static void quickSort(int[] array) {
    int len = array.length;
    if (array == null || len == 0 || len == 1) {
      return;
    }
    sort(array, 0, len - 1);
  }

  public static void sort(int[] array, int left, int right) {
    if (left > right)
      return;
    // base中存放基准数
    int base = array[left], i = left, j = right;
    while (i != j) {
      // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
      while (array[j] >= base && i < j) {
        j--;
      }

      // 再从左往右边找，直到找到比base值大的数
      while (array[i] <= base && i < j) {
        i++;
      }

      // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
      if (i < j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
      }
    }

    // 将基准数放到中间的位置（基准数归位）
    array[left] = array[i];
    array[i] = base;

    showArray(array);// 打印数组
    // 递归，继续向基准的左右两边执行和上面同样的操作
    // i的索引处为上面已确定好的基准值的位置，无需再处理
    sort(array, left, i - 1);
    sort(array, i + 1, right);
  }

  private static void showArray(int[] num) {
    for (int i = 0; i < num.length; i++) {
      System.out.print(num[i] + " ");
    }
    System.out.println();
  }
}
