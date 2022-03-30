package prodsmile.coding.java8plus;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TryWithResource {

    @Test
    public void test() throws FileNotFoundException, IOException {
        var fin = new FileInputStream("somefile");
        try(fin) { // AutoClose
            fin.read();
        }


    }
}
