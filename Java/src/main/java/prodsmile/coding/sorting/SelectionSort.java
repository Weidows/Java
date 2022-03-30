package prodsmile.coding.sorting;

public class SelectionSort implements IMutableSorter {

    @Override
    public void sort(int[] A) {
        for(int i = A.length - 1; i >= 0; i--) {

            // 0 - A[i]
            int j = maxIndex(A, 0, i+1);
            Helper.swap(A, i, j);
        }
    }

    static private int maxIndex(int[] A, int i, int j) {
        int max = Integer.MIN_VALUE;

        int maxIndex = j-1;
        for(int k = j-1; k >= i; k--) {
            if(max < A[k]) {
                max = A[k];
                maxIndex = k;
            }
        }
        return maxIndex;
    }

}
