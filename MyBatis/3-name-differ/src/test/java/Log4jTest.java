import dao.UserMapperTest;
import org.junit.Test;
import org.apache.log4j.Logger;

public class Log4jTest {
  @Test
  public void test() {
    UserMapperTest.getUserList();
    Logger logger = Logger.getLogger(Log4jTest.class);
    logger.info("info: 测试log4j");
    logger.debug("debug: 测试log4j");
    logger.error("error:测试log4j");
  }
}
