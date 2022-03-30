package prodsmile.test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class ExchangerTest {

    AtomicMarkableReference<Integer> am;




    volatile static int a = 0;

    public static void main(String[] argv) {
        // bounded
        var aque = new ArrayBlockingQueue<Integer>(10);

        // optional
        var ldeque = new LinkedBlockingDeque<Integer>(10);
        var ldeque1 = new LinkedBlockingDeque<Integer>();
        var lque = new LinkedBlockingQueue<Integer>(10);
        var lque1 = new LinkedBlockingQueue<Integer>();


        // not-bounded
        var tque = new LinkedTransferQueue<Integer>();
        var sque = new SynchronousQueue<Integer>();
        var pque = new PriorityBlockingQueue<>(10);
        var pque1 = new PriorityBlockingQueue<>();
        var delayque = new DelayQueue<Delayed>();

        Runnable r1 = () -> {

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 10000;
            System.out.println("a="+a);
        };

        Runnable r2 = () -> {
            System.out.println("enter a =" + a);
            while(a < 100) {
            }
            System.out.println("end" + a);
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }

}
