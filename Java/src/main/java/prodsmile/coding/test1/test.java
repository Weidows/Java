package prodsmile.coding.test1;

import org.junit.Test;

import java.util.ArrayList;

public class test {

    class A {}
    class B extends A{}
    @Test
    public void test(){
        ArrayList<? extends A> a = new ArrayList<B>();



    }
}
