package prodsmile.coding.sorting;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSort  {
    public List<Integer> sort(List<Integer> A) {
        int k = 100;
        var buckets = new ArrayList<LinkedList<Integer>>();
        var list = new ArrayList<Integer>();

        for(int i = 0; i < k; i++) {
            buckets.add(new LinkedList<>());
        }

        for(var item : A) {
            buckets.get(item % k).add(item);
        }

        for(var bucket : buckets) {
            list.addAll(bucket);
        }

        return list;

    }
}
