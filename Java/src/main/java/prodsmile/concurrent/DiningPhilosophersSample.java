package prodsmile.concurrent;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersSample implements Runnable {

    ReentrantLock lock = new ReentrantLock();
    int forks[] = new int[5];
    Condition[] waitForks = new Condition[5];
    Condition wait = lock.newCondition();
    Phi[] phis = new Phi[5];
    boolean[] dirty = new boolean[5];
    public DiningPhilosophersSample(){
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
                    var takeLeft = this.checkLeft(forks);

                    if(!takeLeft) {
                       lock.unlock();
                       continue;
                    }
                    this.takeLeft(forks);

                    var takeRight = this.checkRight(forks);
                    if(takeRight) {
                        this.takeRight(forks);
                    } else {
                        var rid = this.right();
                        var rPhi = phis[forks[rid] - 1];
                        if(dirty[rid] && rPhi.getState() != "Eating") {
                           forks[rid] = this.id;
                           dirty[rid] = false;
                        } else {
                            lock.unlock();
                            continue;
                        }
                    }
                    lock.unlock();
                    this.eating();

                    lock.lockInterruptibly();
                    this.putLeft(forks);
                    this.putRight(forks);
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
        var solver = new DiningPhilosophersSample();
        solver.run();

    }
}
