package prodsmile.coding.stream;


import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BasicExamples {


    @Test
    public void test_mapfilter() {
        Stream.of(1,2,3,4,5,6)
                .map(Object::toString)
                .map(x -> x + x)
                .map(x -> x + x + x)
//                .map(x -> Integer.parseInt(x))
                .map(Integer::parseInt)
                .forEach(System.out::println);
        // function reference operator
        // lambda expression
    }

    @Test
    public void test_mapfilterreduce(){
        //var result = Stream.of(1,2,3,4,5,)
        var result = IntStream.of()
                    .map(x -> x * x)
                    .filter(x -> x < 20)
                    .reduce( Math::max);
//                    .orElse(0);
                    //.reduce(0, Integer::min);
        System.out.println(result.isPresent());
        System.out.println(result.orElseGet(() -> 0));
    }

    @Test
    public void test_mutation() {
        var stream = Stream.of(1,3,5,2,3,4,5,6).sorted();
        stream.forEach(System.out::println);
    }

    @Test
    public void test_flatMap(){
        // String -> Stream<R>
        var set = Stream.of("My", "Mine")
                .flatMap(str -> str.chars().mapToObj(i -> (char)i))
                .collect(Collectors.toSet());
        System.out.println(new ArrayList<>(set));
//        System.out.println(set.stream().collect(Collectors.toList()));
    }

    @Test
    public void test_parallel() throws ExecutionException, InterruptedException {

        var r = new Random();
        var list = IntStream.range(0, 1_000_000)
                .map(x -> r.nextInt(10_000_000))
                .boxed()
                .collect(Collectors.toList());

        var t0 = System.currentTimeMillis();
        System.out.println(list.stream().max(Comparator.comparingInt(x -> x)));
        System.out.println("time:" + (System.currentTimeMillis() - t0));

        // 1000
        var pool = new ForkJoinPool(2);
        var t1 = System.currentTimeMillis();
        var max = pool.submit(() -> list.parallelStream().max(Comparator.naturalOrder())).get();

//        list.stream().parallel().max((a , b) -> a -b);

        // 15
        // Spliter 1024 -> Thread0 1024 -> Thread1

        System.out.println("time:" + (System.currentTimeMillis() - t1) + ",max:" + max);
    }




}
