package prodsmile.test;

import java.util.concurrent.TimeUnit;

public class ReOrdering {

    volatile static int a = 0;

    public static void main(String[] argv) {
        Runnable r1 = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a = 10000;
            System.out.println("set a");
        };

        Runnable r2 = () -> {
            while(a < 100) {

            }

            System.out.println("end:" + a);
        };

        new Thread(r1).start();
        new Thread(r2).start();

    }
}
