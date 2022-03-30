package prodsmile.coding.java8plus;

import org.junit.Test;

import java.util.Arrays;

public class Examples {

    @Test
    public void test_nested() throws NoSuchFieldException {

        class A {
            private int a;

        }

        class B {

            public void foo() throws NoSuchFieldException {

                var filed = A.class.getDeclaredField("a");
                System.out.println(filed);
            }

        }

        System.out.println("A nested host : " + A.class.getNestHost());
        System.out.println("A nested members: " + Arrays.toString(A.class.getNestMembers()));
        System.out.println("B nested host : " + B.class.getNestHost());
        System.out.println("B nested members: " + Arrays.toString(B.class.getNestMembers()));

        var b = new B();
        b.foo();

    }
}
