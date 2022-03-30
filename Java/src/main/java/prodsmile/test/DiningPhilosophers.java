package prodsmile.test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophers {

    enum PHIS {
        THINKING,
        HUNGRY,
        EATING
    }
    static class Philosopher implements Runnable {

        private static Philosopher[] philosophers;
        private static Integer[] forks;
        private static boolean[] dirty;
        private PHIS state = PHIS.THINKING;
        static {
            philosophers = new Philosopher[5];
            forks = new Integer[5];
            dirty = new boolean[5];
            for(int i = 0; i < 5; i++) {
                philosophers[i] = new Philosopher(i);
                forks[i] = -1;
                dirty[i] = true;
            }
        }

        private static int LEFT(int i) {
            return i == 0 ? 4 : i-1;
        }

        public Philosopher(int id) {
            this.id = id;
        }

        private int id;

        void think() throws InterruptedException {
            System.out.println(String.format("Philosopher %d thinking...", id));
            Thread.sleep((long) Math.floor(Math.random()*1000));
            this.state = PHIS.HUNGRY;
        }
        void eat() throws InterruptedException {
            synchronized (forks) {
                    System.out.println(Arrays.toString(forks));
                    //System.out.println(Arrays.toString(dirty));
                    if(forks[LEFT(id)] == id && forks[id] == id) {
                        this.state = PHIS.EATING;
                    } else {
                        return;
                    }
            }
            System.out.println(String.format("Philosopher %d eating...", id));
            Thread.sleep((long) Math.floor(Math.random()*1000));

            synchronized (forks) {
                dirty[LEFT(id)] = true;
                dirty[id] = true;
            }


            var lock = new ReentrantLock();

            lock.tryLock(5, TimeUnit.SECONDS);

            state = PHIS.THINKING;
        }

        void _take(int i) throws InterruptedException {
            Thread.sleep(10);
            forks[i] = id;
        }

        void _transfer(int fork, int philosopher) {
            forks[fork] = philosopher;
            dirty[fork] = false;
        }

        void _putdown(int i) throws InterruptedException {
            Thread.sleep(10);
            forks[i] = -1;
        }

        void take(int i) throws InterruptedException {

            synchronized (forks[i]) {
                if(forks[i] == -1) {
                    _take(id);
                } else {
                    Philosopher other = philosophers[forks[i]];
                    if(other.state != PHIS.EATING && dirty[i]) {
                        other._transfer(i, forks[i]);
                    }
                }
            }
        }


        void takeForks() throws InterruptedException {
            take(LEFT(id));
            take(id);
        }

        @Override
        public void run() {
            try {
                while(true) {
                    think();
                    while (state == PHIS.HUNGRY) {
                        takeForks();

                        System.out.println("here--" + Math.random());
                        eat();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i < 5; i++) {
            new Thread(new Philosopher(i)).start();
        }

    }
}
