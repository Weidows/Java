package prodsmile.concurrent;

import java.util.concurrent.*;

public class DiningPhilosophersBlockingQueue implements Runnable {

    Philosopher[] phis;
    volatile int forks[];
    LinkedBlockingQueue<Philosopher> workingQueue;
    LinkedBlockingQueue<Philosopher> managerQueue;
    DelayQueue<DelayInterruptingThread> delayQueue = new DelayQueue<>();

    class DelayInterruptingThread implements Delayed{

        long time;
        Thread current;

        public DelayInterruptingThread(Thread t, long delay) {
            this.current = t;
            this.time = System.currentTimeMillis() + delay;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return time - System.currentTimeMillis();
        }

        @Override
        public int compareTo(Delayed o) {
            return (int) (time - ((DelayInterruptingThread)o).time);
        }

        public void rollback() {
            if(this.current != null) {
                this.current.interrupt();
            }
        }

        public void commit() {
            this.current = null;
        }
    }



    class Worker implements Runnable {
        @Override
        public void run() {

            while (true) {
                Philosopher phi = null;
                try{
                    phi = workingQueue.take();
                    if(phi.getState()=="Hungry") {
                        var delayItem = new DelayInterruptingThread(Thread.currentThread(), 1000);
                        delayQueue.offer(delayItem);
                        phi.eating();
                        delayItem.commit();
                        phi.putLeft(forks);
                        phi.putRight(forks);
                        phi.finished();
                        workingQueue.offer(phi);
                    } else {
                        phi.thinking();
                        managerQueue.offer(phi);
                    }
                } catch (InterruptedException e) {
                    if(phi != null) {
                        phi.putLeft(forks);
                        phi.putRight(forks);
                        if(phi.getState() == "Eating") {
                            phi.setState("Hungry");
                        }
                        managerQueue.offer(phi);

                    }
                }

            }
        }
    }

    class InterruptingWorker implements Runnable {

        @Override
        public void run() {

            while (true) {
                try {
                    var delayed = (DelayInterruptingThread)delayQueue.take();
                    delayed.rollback();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    class ContentionManager implements Runnable {

        @Override
        public void run() {
            while(true) {
                try {
                    var phi = managerQueue.take();
                    if(phi.checkLeft(forks) && phi.checkRight(forks)) {
                        phi.takeLeft(forks);
                        phi.takeRight(forks);
                        workingQueue.offer(phi);
                    } else {
                        managerQueue.offer(phi);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public DiningPhilosophersBlockingQueue() {
        phis = new Philosopher[5];
        forks = new int[5];
        workingQueue = new LinkedBlockingQueue<>();
        managerQueue = new LinkedBlockingQueue<>();
        for(int i = 0; i < 5; i++) {
            phis[i] = new Philosopher(i+1);
            workingQueue.offer(phis[i]);
        }
    }



    public void run(){
        var pool = Executors.newFixedThreadPool(7);
        for(int i = 0; i < 5; i++) {
            pool.submit(new Worker());
        }
        pool.submit(new ContentionManager());
        pool.submit(new InterruptingWorker());
    }


    public static void main(String[] argv) {

        var solver = new DiningPhilosophersBlockingQueue();
        solver.run();
    }
}
