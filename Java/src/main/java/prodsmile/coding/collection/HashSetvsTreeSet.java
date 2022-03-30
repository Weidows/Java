package prodsmile.coding.collection;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class HashSetvsTreeSet {

  @Test
  public void test_order() {
    var hashSet = new HashSet<Integer>() {{
      add(3);
      add(7);
      add(2);
      add(81);
    }};

    // System.out.println(hashSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
    System.out.println(hashSet.stream().map(Object::toString).collect(Collectors.joining(",")));

    var treeSet = new TreeSet<Integer>() {{
      add(3);
      add(7);
      add(2);
      add(81);
    }};

    System.out.println(treeSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));
  }

  @Test
  public void test_benchmark() {

    var random = new Random();
    LinkedList<String> words = new LinkedList<>();
    for (int i = 0; i < 1000000; i++) {

      var word = random.ints(97, 123)
          .limit(12)
          .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
          .toString();

      words.add(word);
    }


    var hashSet = new HashSet<String>();
    var treeSet = new TreeSet<String>();

    var start = System.currentTimeMillis();
    for (var w : words) {
      hashSet.add(w);
    }
    for (var w : words) {
      hashSet.contains(w);
    }
    System.out.println("hashSet time:" + (System.currentTimeMillis() - start));

    start = System.currentTimeMillis();
    for (var w : words) {
      treeSet.add(w);
    }
    for (var w : words) {
      treeSet.contains(w);
    }
    System.out.println("treeSet time:" + (System.currentTimeMillis() - start));
  }


}
