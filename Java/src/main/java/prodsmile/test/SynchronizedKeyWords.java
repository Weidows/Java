package prodsmile.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedKeyWords {

    public static void main(String[] argv) {
        var lock = new ReentrantLock();

        var t = new Thread(() -> {
            try {
                lock.tryLock(1000, TimeUnit.MICROSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lock) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("finished.");
            }
        });
        t.start();
        t.interrupt();


    }
}
