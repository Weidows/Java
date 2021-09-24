package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
  @Test
  public void test() {
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

  @Test
  public void test1() {
    //1.获取SqlSession对象
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    //2.执行SQL
    List<User> userList = sqlSession.selectList("dao.UserMapper.getUserList");
    for (User user : userList) {
      System.out.println(user);
    }
    //关闭sqlSession
    sqlSession.close();
  }

  @Test
  public void getUserById() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    System.out.println(mapper.getUserById(3));
    sqlSession.close();
  }

  @Test
  public void addUser() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int i = mapper.addUser(new User(5, "五号", "123456"));
    if (i > 0) {
      //注意 增删改 需要提交事务
      sqlSession.commit();
    }
    sqlSession.close();
  }

  @Test
  public void updateUser() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int i = mapper.updateUser(new User(5, "⑤号", "654321"));
    if (i > 0) {
      sqlSession.commit();
    }
    sqlSession.close();
  }

  @Test
  public void deleteUser() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    int i = mapper.deleteUser(5);
    if (i > 0) {
      sqlSession.commit();
    }
    sqlSession.close();
  }

  @Test
  public void addUser2() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    HashMap<String, Object> map = new HashMap<>();
    map.put("userid", 6);
    map.put("username", "王虎");
    map.put("userpassword", 789);

    int i = mapper.addUser2(map);
    if (i > 0) sqlSession.commit();
    sqlSession.close();
  }

}
