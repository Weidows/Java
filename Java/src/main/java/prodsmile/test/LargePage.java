package prodsmile.test;

import java.util.ArrayList;

public class LargePage {

    public static void main(String[] argv) throws InterruptedException {
        var array = new ArrayList<>(100000);

        synchronized (array){
            array.wait();
        }

    }
}
