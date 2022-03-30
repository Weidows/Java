package prodsmile.concurrent;


import java.util.concurrent.Executors;

public class DiningPhilosophersDeadlock {

    Phi[] phis = new Phi[5];
    volatile int[] forks = new int[5];

    public DiningPhilosophersDeadlock(){
        for(int i = 0; i < 5; i++) {
            phis[i] = new Phi(i+1);
            forks[i] = 0;
        }

    }

    class Phi extends Philosopher {

        public Phi(int id) {
            super(id);
        }

        @Override
        protected synchronized boolean takeLeft(int[] forks) {
            return super.takeLeft(forks);
        }

        @Override
        protected synchronized boolean takeRight(int[] forks) {
            return super.takeRight(forks);
        }

        public void run(){
            while(true) {
                try {
                    this.thinking();
                    while(!this.takeLeft(forks)) {
                        Thread.onSpinWait();
                    }
                    Thread.sleep(100);
                    int c = 0;
                    // livelock
                    // deadlock
                    while(!this.takeRight(forks)) {
                        c++;
                        if(c > 100) {
                            this.putLeft(forks);
                            continue;
                        }
                        Thread.onSpinWait();
                    }
                    this.eating();
                    this.putLeft(forks);
                    this.putRight(forks);
                    this.finished();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void run(){
        var pool = Executors.newFixedThreadPool(5);
        for(int i = 0; i< 5; i++) {
            pool.submit(phis[i]);
        }
    }

    public static void main(String[] argv) {
        var solver = new DiningPhilosophersDeadlock();
        solver.run();
    }
}
