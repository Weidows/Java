package prodsmile.coding.sorting;

public class QuickSort1 implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        this.quickSort(A, 0, A.length);
    }

    private void quickSort(int[] A, int l, int r) {

        if(r - l <= 1) {
            return;
        }
        // 选择最左边的元素构造子问题集合
        // 小于x的放到左边，大于x的放到右边
        // int x = A[l];
        // i代表x的位置
        int i = partition(A, l, r);

        // 省略计算x所在位置i
        // 以及将所有小于x的元素放到左边，大于x元素放到右边的
        quickSort(A, l, i);
        quickSort(A, i+1, r);

    }

    private int partition(int[] A, int l, int r) {
        int x = A[l];

        int i = l + 1;
        int j = r;

        while(i != j) {
            if(A[i] < x) {
                i++;
            } else {
               Helper.swap(A, i, --j);
            }
        }
        Helper.swap(A, i-1, l);
        return i-1;

    }


}
