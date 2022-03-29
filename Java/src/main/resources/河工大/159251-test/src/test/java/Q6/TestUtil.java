package Q6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ClassUtils;

import java.lang.reflect.Method;


/**
 * Q6
 * @author add name here
 * @id add ID here
 */

public class TestUtil {
    @Test
    public void shouldDivide() {
        assertEquals(5.0, Util.divide(5,0));
    }

  @Test
  public void testGetTitle() throws Exception {
    Util util = new Util();
    Method getTitle = util.getClass().getDeclaredMethod("getTitle", Person.class);
    getTitle.setAccessible(true);
    String result = (String) getTitle.invoke(util, new Person("John","M"));
    assertEquals("Mr.", result);
  }
}
