package utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory --> sqlSession
public class MyBatisUtils {
  private static SqlSessionFactory sqlSessionFactory = null;

  static {
    try {
      //使用Mybatis第一步 ：获取sqlSessionFactory对象
      String resource = "MyBatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例.
   * SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
   */
  public static SqlSession getSqlSession(){
    return sqlSessionFactory.openSession();
  }
}
