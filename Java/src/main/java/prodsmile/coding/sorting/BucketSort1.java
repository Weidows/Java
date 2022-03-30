package prodsmile.coding.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort1 {
    public List<Integer> sort(List<Integer> A, int k, int max, int min) {
        var buckets = new ArrayList<LinkedList<Integer>>();
        var list = new ArrayList<Integer>();
        var D = max - min + 1;
        var quickSort = new QuickSort();
        for(int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }

        // 放入桶中
        for(var item : A) {
            var key = (item - min) * k / D;
            buckets.get(key).add(item);
        }

        //从桶中取出值
        for(int i = 0; i < k; i++) {
            list.addAll(quickSort.sort(buckets.get(i)));
        }

        return list;

    }
}
