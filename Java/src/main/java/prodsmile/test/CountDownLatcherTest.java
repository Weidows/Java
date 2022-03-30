package prodsmile.test;

import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class CountDownLatcherTest {

    class RPC implements Runnable{
        String url;
        CountDownLatch latch;
        public RPC(String url, CountDownLatch latch){
            this.url = url;
            this.latch = latch;
        }

        @Override
        public void run() {
            System.out.println("request");
            latch.countDown();
        }
    }
    public void run() throws InterruptedException {
        var requests = new ArrayList<RPC>();
        var latch = new CountDownLatch(4);
        requests.add(new RPC("rpc://A", latch));
        requests.add(new RPC("rpc://B", latch));
        requests.add(new RPC("rpc://C", latch));
        requests.add(new RPC("rpc://D", latch));
        requests.forEach((x) -> new Thread(x).start());
        latch.await();
        // merge 4 request result
        System.out.println("merge");

    }

    public static void main(String[] argv) throws InterruptedException {
        var test = new CountDownLatcherTest();
        test.run();
    }

}
