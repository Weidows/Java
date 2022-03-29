/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-06-06 11:30:19
 * @LastEditors: Weidows
 * @LastEditTime: 2021-06-06 17:09:25
 * @FilePath: \Weidows\Java\src\main\java\homework\done\test\seven\Seven.java
 * @Description:
 * @!: *********************************************************************
 */
package works.done.poly_technic_university_test.seven;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Seven {

  //using java stream constructs, create a static method to return the largest of a given list of integers
  static Integer maxList(List<Integer> l) {
    Optional<Integer> max = l.stream().max(Integer::max);
    return max.get();
  }

  public static void main(String[] args) {

	  // create a potentially infinite stream of doubles, beginning from 2.0, where each is half of the previous number
	  // Stream<Double> halves = ???


	  // create a potentially infinite stream of strings of the form "even", "odd", "even", "odd", "even" ... and so on...
	  // Stream<String> altStrings = ???


	 // a potentially infinite stream of Fibonacci numbers, as pairs
	 Stream<int[]> fibs = Stream.iterate(new int[] {0, 1}, t -> new int[] {t[1], t[0] + t[1]});

	 // using takeWhile to create a stream of integers, 1 to 9
     Stream<Integer> somenums = Stream.iterate(1, i -> i+1).takeWhile(i -> i < 10);
	 somenums.forEach(System.out::println);

	 // using fibs, map and takeWhile, create a stream of Fibonacci numbers < 100
	//  Stream<Integer> smallFibs = ???


	//  halves.limit(10).forEach(System.out::println);
	//  smallFibs.forEach(System.out::println);
	//  altStrings.limit(10).forEach(System.out::println);
	 List<Integer >myList = new ArrayList<>();
	 myList.add(3);
	 myList.add(1);
	 myList.add(47);
	 myList.add(5);
	 myList.add(6);
	 System.out.println(maxList(myList));


	 // boolean oneEven = Stream.iterate(1, i -> i + 1).noneMatch(i -> {System.out.println(i); return i % 2 == 0;});
	 // boolean allEven = Stream.iterate(0, i -> i + 2).allMatch(i -> {System.out.println(i); return i % 2 == 0;});

	 // System.out.println(oneEven);
	 // System.out.println(allEven);

	}

}
