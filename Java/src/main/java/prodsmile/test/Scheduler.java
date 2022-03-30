package prodsmile.test;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Scheduler {

    SynchronousQueue<Runnable> tasks = new SynchronousQueue<>(false);
    //LinkedTransferQueue<Runnable> tasks = new LinkedTransferQueue<>();

    static AtomicInteger idCount = new AtomicInteger(0);

    public Scheduler(int workers) {
        for(int i = 0; i < workers; i++) {
            new Thread(new Worker()).start();
        }
    }

    class Worker implements Runnable {

        int id;
        public Worker(){
            this.id = idCount.getAndIncrement();
        }

        @Override
        public void run() {
            while(true) {
                Runnable runnable = null;
                try {
                    runnable = tasks.take();
                    runnable.run();
                    System.out.format("work done by id=%d\n", id);
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void submit(Runnable r) throws InterruptedException {
        //tasks.offer(r)
        // DualQueue
        // LinkedBlockingQueue
//        while(!tasks.tryTransfer(r)) {
//            Thread.onSpinWait();
//            new Thread(new Worker()).start();
//        }
        if(!tasks.offer(r)){
            Thread.onSpinWait();
            new Thread(new Worker()).start();
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        var scheduler = new Scheduler(10);

        for(int i = 0; i < 1000; i++) {
            var localI = i;
            Thread.sleep(1);
            scheduler.submit(() -> {
                try{
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

    }

}
