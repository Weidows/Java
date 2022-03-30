package prodsmile.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {

    Phaser phaser = new Phaser();
    ExecutorService executorService = Executors.newCachedThreadPool();

    class Worker implements Runnable{
        @Override
        public void run(){
            // 4 --- sync --- 4 --- sync --..
            phaser.register();

            while(true) {
                try {
                    Thread.sleep(500);
                    System.out.println("I'm working:@" + phaser.getPhase());
                    phaser.arriveAndAwaitAdvance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }


    public void run() throws InterruptedException {
        // main thread
        phaser.register();
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        executorService.execute(new Worker());
        while(true) {
            phaser.arriveAndAwaitAdvance();
            System.out.println("Sync...." + phaser.getPhase());
        }
    }

    public static void main(String[] argv) throws InterruptedException {
        var test = new PhaserTest();
        test.run();
    }

}
