package prodsmile.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;


public class DiningPhilosophersWithTransfer implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    int forks[] = new int[5];
    Condition[] waitForks = new Condition[5];
    Phi[] phis = new Phi[5];
    boolean[] dirty = new boolean[5];
    public DiningPhilosophersWithTransfer(){
        for(int i = 0; i < 5; i++) {
            phis[i] = new Phi(i+1);
            dirty[i] = true;
            waitForks[i] = lock.newCondition();
        }
    }

    class Phi extends Philosopher {

        public Phi(int id) {
            super(id);
        }

        @Override
        public void run() {
            while(true) {
                try {
                    this.thinking();
                    lock.lockInterruptibly();
                    while(!this.takeLeft(forks)) {
                        waitForks[this.left()].await();
                    }
                    while(!this.takeRight(forks)) {
                        var rid = this.right();
                        var rightPhi = phis[forks[rid] -1];

                        if(rightPhi.getState() != "Eating" && dirty[rid] == true) {
                            forks[rid] = this.id;
                            dirty[rid] = false;
                            break;
                        }
                        waitForks[this.right()].await();
                    }
                    lock.unlock();

                    this.eating();
                    lock.lockInterruptibly();
                    this.putLeft(forks);
                    waitForks[this.left()].signalAll();
                    this.putRight(forks);
                    waitForks[this.right()].signalAll();
                    dirty[this.left()] = true;
                    dirty[this.right()] = true;
                    lock.unlock();
                    this.finished();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void run() {
        //var pool = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 5; i++) {
            new Thread(phis[i]).start();
        }
    }

    public static void main(String[] argv) {
        var solver = new DiningPhilosophersWithTransfer();
        solver.run();

    }
}

