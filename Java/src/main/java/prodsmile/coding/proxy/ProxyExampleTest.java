package prodsmile.coding.proxy;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ProxyExampleTest {


    @Test
    public void test_proxy() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, ClassNotFoundException, InterruptedException {
        IOrder order = Aspect.getProxy(Order.class, "prodsmile.coding.proxy.TimeUsageAspect");
        order.pay();
        order.show();
    }


}
