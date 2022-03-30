package prodsmile.jvm;

import org.junit.Test;

import java.util.ArrayList;

public class OutOfHeap {


    public static void main(String[] argv) throws InterruptedException {

        var a = new int[1024*1024];
        var b = new int[1024*1024];
        var c = new int[1024*1024*3];
        a = null;
        b = null;
        c = null;
        Thread.sleep(1000);
        var d = new int[1024*1024];
        // if you want overflow
        //var e = new int[1024*1024*4];
        System.gc();
    }

    @Test
    public void test_outofmem() throws InterruptedException {
        var list = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            Thread.sleep(100);
            list.add(new int[1024*256]);
        }
    }



}
