package dao;

import pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
  List<User> getUserList();

  User getUserById(int id);

  int addUser(User user);

  int updateUser(User user);

  int deleteUser(int id);

  //用Map插入用户
  int addUser2(Map<String, Object> map);

}
