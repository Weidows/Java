package prodsmile.coding.java8plus;

import org.junit.Test;

import java.util.Arrays;

public class Nested {

    class A{

        private String name = "123";
    }

    class B{
        public void bar() throws NoSuchFieldException {
            System.out.println(A.class.getDeclaredField("name"));
        }

    }

    @Test
    public void test() throws NoSuchFieldException {
        var b = new B();
        b.bar();
        // name

        System.out.println(Arrays.toString(A.class.getNestMembers()));
        // [Nested, A, B]

        System.out.println(A.class.getNestHost());
        // Nested

        System.out.println(Arrays.toString(B.class.getNestMembers()));
        // [Nested, A, B]

        System.out.println(B.class.getNestHost());
        // Nested
    }
}
