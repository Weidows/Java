package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.List;

public class UserMapperTest {

  @Test
  public static void getUserList() {
    //1.获取SqlSession对象
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    //2.执行SQL
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = userMapper.getUserList();
    for (User user : userList) {
      System.out.println(user);
    }
    //关闭sqlSession
    sqlSession.close();
  }
}
