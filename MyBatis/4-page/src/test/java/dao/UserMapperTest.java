package dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.User;
import utils.MyBatisUtils;

import java.util.HashMap;
import java.util.List;

public class UserMapperTest {
  @Test
  public void getUserByLimit() {
    SqlSession sqlSession = MyBatisUtils.getSqlSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);

    HashMap<String, Integer> map = new HashMap<>();
    map.put("startIndex", 1);
    map.put("pageSize", 2);

    List<User> list = mapper.getUsersByLimit(map);
    for (User user : list) {
      System.out.println(user);
    }
    sqlSession.close();
  }

}
