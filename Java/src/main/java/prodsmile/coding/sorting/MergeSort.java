package prodsmile.coding.sorting;

import java.util.Arrays;

public class MergeSort implements IMutableSorter {
    @Override
    public void sort(int[] A) {
        mergeSort(A, 0, A.length);
    }

    private void mergeSort(int[] A, int l, int r) {

        // stack overflow
        if(r - l <= 1) {
            return;
        }

        int mid = (l+r+1)/2;
        mergeSort(A, l, mid);
        mergeSort(A, mid, r);

        merge(A, l, mid, r);

    }

    private void merge(int[] A, int l, int mid, int r) {
        int[] B = Arrays.copyOfRange(A, l, mid+1);
        int[] C = Arrays.copyOfRange(A, mid, r+1);


        B[B.length-1] = C[C.length - 1] = Integer.MAX_VALUE;

        int i = 0, j = 0;

        for(int k = l; k < r; k++) {
            if(B[i] < C[j]) {
                A[k] = B[i++];
            } else {
                A[k] = C[j++];
            }
        }

    }

}
