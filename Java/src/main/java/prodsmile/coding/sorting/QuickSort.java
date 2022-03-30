package prodsmile.coding.sorting;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class QuickSort implements IImutableSorter{
    @Override
    public List<Integer> sort(List<Integer> A) {
        return this.quickSort(A);
    }

    private List<Integer> quickSort(List<Integer> A) {

        if(A.size() <= 1) {
            return A;
        }
        // |---left---| x | ---right ---||
        var x = A.get(0);
        var left = A.stream().filter(a -> a < x)
                    .collect(toList());
        var mid = A.stream().filter(a -> a == x)
                .collect(toList());
        var right = A.stream().filter(a -> a > x)
                .collect(toList());
        left = quickSort(left);
        right = quickSort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }


}
