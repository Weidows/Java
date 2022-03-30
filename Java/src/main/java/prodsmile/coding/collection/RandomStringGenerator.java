package prodsmile.coding.collection;

import java.util.*;

public class RandomStringGenerator<T> implements Iterable<T> {
  private final List<T> list;

  public RandomStringGenerator(List<T> list) {
    this.list = list;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      @Override
      public boolean hasNext() {
        return true;
      }

      @Override
      public T next() {
        return list.get((int) (Math.random() * list.size()));
      }
    };
  }

  public static void main(String[] args) {
    RandomStringGenerator<String> randomStringGenerator = new RandomStringGenerator<>(Arrays.asList("a", "b", "c"));

    // 会一直输出,死循环
    // for (var s : randomStringGenerator) {
    //   System.out.println(s);
    // }

    Iterator<String> iterator = randomStringGenerator.iterator();
    for (int i = 0; i < 100; i++) {
      System.out.println(iterator.next());
    }
  }
}
