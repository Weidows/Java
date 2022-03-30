package prodsmile.coding.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortTests {

    @Test
    public void test_insertionSort(){
        sortTest(InsertionSort.class, 100000);
    }

    @Test
    public void test_selectionSort() {
        sortTest(SelectionSort.class, 100000);
    }

    @Test
    public void test_bubbleSort(){
        sortTest(BubbleSort.class, 100000);
    }

    @Test
    public void test_mergeSort(){
        sortTest(MergeSort.class, 100000);
    }

    @Test
    public void test_quickSort(){
        sortTest(QuickSort.class, 100000);
    }

    @Test
    public void test_quicksort1(){
        sortTest(QuickSort1.class, 1000000);
    }

    @Test
    public void test_quicksort(){
        sortTest(QuickSort.class, 1000000);
    }

    @Test
    public void test_bucketSort(){
        var bucketSort = new BucketSort();
        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 0; i < 1000000; i++) {
            l.add((int) (Math.random() * 100));
        }
        var start = System.currentTimeMillis();
        List<Integer> A = bucketSort.sort(l);
        System.out.println("time:" + (System.currentTimeMillis() - start));
        assertSorted(A);
    }

    @Test
    public void test_bucketSort1(){
        var bucketSort = new BucketSort1();
        ArrayList<Integer> l = new ArrayList<>();

        for(int i = 0; i < 1000000; i++) {
            l.add(100 + (int) (Math.random() * 1000));
        }
        var start = System.currentTimeMillis();
        List<Integer> A = bucketSort.sort(l, 10, 1100, 100);
        System.out.println("time:" + (System.currentTimeMillis() - start));
        assertSorted(A);
    }

    public void sortTest(Class cls, int N){


        try {
            var constructor = cls.getConstructor();
            var rawInst = constructor.newInstance();
            var start = System.currentTimeMillis();
            if(rawInst instanceof IImutableSorter) {
                var A = gen(N);
                var inst = (IImutableSorter)rawInst;
                A = inst.sort(A);
                System.out.println("time usage:" + (System.currentTimeMillis() - start));
                assertSorted(A);

            } else if(rawInst instanceof IMutableSorter) {
                var A = gen(N).stream().mapToInt(x->x).toArray();
                var inst = (IMutableSorter)rawInst;
                inst.sort(A);
                System.out.println("time usage:" + (System.currentTimeMillis() - start));
                assertSorted(A);
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void assertSorted(int[] A) {
        assertSorted(Arrays.stream(A).boxed().collect(Collectors.toList()));
    }

    static void assertSorted(List<Integer> A) {
        Integer o = Integer.MIN_VALUE;
        for (var i : A) {
            if (o > i) {
                System.out.println(A.toString());
                Assert.fail("Array not in sorted order");
            }
            o = i;

        }
    }

    static List<Integer> gen(int n){
        var A = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            A.add((int) (Math.random() * n));
        }
        return A;
    }
}
