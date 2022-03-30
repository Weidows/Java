package prodsmile.test;

import java.util.concurrent.*;

public class BlockingQueueTest {


    public static void main(String[] argv) {
        BlockingQueue<Integer> queue;
        //queue = new ArrayBlockingQueue<Integer>(10);
        //queue = new LinkedBlockingQueue<Integer>();
        //queue = new LinkedBlockingDeque<>();
        //queue = new PriorityBlockingQueue<>();
        //queue = new LinkedTransferQueue<Integer>();
        queue = new SynchronousQueue<>();
        //queue = new DelayQueue<>();

        // Producer
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                try {
                    queue.put((int) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Consumer
        for(int i = 0; i < 10; i++) {
            new Thread(() -> {
                while(true) {
                    Integer x = null;
                    try {
                        x = queue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Receive:" + x);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }).start();
        }

    }
}
