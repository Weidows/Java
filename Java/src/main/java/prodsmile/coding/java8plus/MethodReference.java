package prodsmile.coding.java8plus;

import org.junit.Test;

import java.util.List;

public class MethodReference {
    @Test
    public void test(){
        // 1-2-3-4-5
        var val = List.of(1,2,3,4,5).stream()
                .map(Object::toString)
                .map(Integer::new)
                .reduce((a,b)->a+b);

        System.out.println(val);

    }
}
