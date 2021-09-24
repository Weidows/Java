package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.List;

public class UserMapperTest {

  @Test
  public void getUsers() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    List<User> userList = userMapper.getUsers();
    for (User user : userList) {
      System.out.println(user);
    }
    sqlSession.close();
  }

  @Test
  public void testGetUserById() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.getUserById(1);
    System.out.println(user);
    sqlSession.close();
  }

  @Test
  public void getUserById() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = userMapper.getUserByIdAndName(1, "张三");
    System.out.println(user);
    sqlSession.close();
  }

  @Test
  public void addUser() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    int i = userMapper.addUser(new User(7, "七七", "45648"));
    if (i > 0)
      sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void updateUser() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    int i = userMapper.updateUser(new User(7, "七七", "12345678"));
    if (i > 0)
      sqlSession.commit();
    sqlSession.close();
  }

  @Test
  public void deleteUserById() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    if (userMapper.deleteUserById(7) > 0)
      sqlSession.commit();
    sqlSession.close();
  }
}
