package prodsmile.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Philosopher implements Runnable{

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    String state;
    int id;
    int count = 0;
    static AtomicInteger total = new AtomicInteger(0);
    static long startMills = System.currentTimeMillis();

    public Philosopher(int id){
        this.id = id;
        this.state = "Thinking";
    }

    public void thinking() throws InterruptedException {
        if(this.state == "Thinking") {
            Thread.sleep((long)(Math.random()*100));
            this.state = "Hungry";
        }
    }


    public void eating() throws InterruptedException {
        this.state = "Eating";
        if(Math.random() > 0.9) {
            Thread.sleep(100000);
        } else {
            Thread.sleep((long)(Math.random()*100));
        }
//        this.state = "Thinking";
    }

    public int left(){
        return this.id - 1;
    }

    public int right(){
        return this.id % 5;
    }

    private boolean _take(int[] forks, int fork) {
        if(forks[fork] == 0) {
            forks[fork] = this.id;
            return true;
        }
        return false;
    }

    protected boolean takeLeft(int[] forks) {
        return this._take(forks, this.left());
    }
    protected boolean takeRight(int[] forks) {
        return this._take(forks, this.right());
    }

    protected void putRight(int[] forks) {
        if(forks[this.right()] == this.id) {
            forks[this.right()] = 0;
        }
    }
    protected void putLeft(int[] forks) {
        if(forks[this.left()] == this.id) {
            forks[this.left()] = 0;
        }
    }

    protected boolean checkLeft(int[] forks) {
        return forks[this.left()] == 0;
    }

    protected boolean checkRight(int[] forks) {
        return forks[this.right()] == 0;
    }

    public void finished(){
        count ++;
        int t = total.incrementAndGet();
        double speed = (t * 1000.0) / (System.currentTimeMillis() - startMills);
        this.state = "Thinking";
        System.out.format("Philosopher %d finished %d times, speed = %.2f.\n",
                this.id,
                this.count,
                speed
        );
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException();
    }
}