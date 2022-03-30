package prodsmile.test;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
public class ProducerCustomerModel {
    final static int MAX = 10;
    LinkedList<Integer> queue = new LinkedList<>();

    ReentrantLock lock = new ReentrantLock();
    Condition full = lock.newCondition();
    Condition emtpy = lock.newCondition();


    int readData() throws InterruptedException {

        Thread.sleep((long)Math.random()*1000);
        return (int)Math.floor(Math.random());
    }



    // Producer
    public void readDb() throws InterruptedException {
        lock.lock();
        if (queue.size() == MAX) {
            full.await();
            return;
        }
        var data = readData(); // 1s
        if(queue.size() == 1) {
            emtpy.signalAll();
        }
        queue.add(data);
        lock.unlock();
    }

    // Comsumer
    public void calculate() throws InterruptedException {

        lock.lock();
        if (queue.size() == 0) {
            emtpy.await();
            return;
        }
        var data = queue.remove();
        System.out.println("queue-size:" + queue.size());
        if(queue.size() == MAX - 1) {
            full.signalAll();
        }

        data *= 100;
        lock.unlock();
    }


    public static void main(String[] argv) {
        var p = new ProducerCustomerModel();
        for(int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    try {
                        p.readDb();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        new Thread(() -> {
            while(true) {
                try {
                    p.calculate();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
