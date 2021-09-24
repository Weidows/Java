package com.weidows.dao.user;


import com.weidows.pojo.User;

import java.sql.Connection;
import java.util.List;

public interface UserDao {

  /**
   * 通过userCode获取User
   *
   * @param connection
   * @param userCode
   * @return
   * @throws Exception
   */
  User getLoginUser(Connection connection, String userCode) throws Exception;

  /**
   * 增加用户信息
   *
   * @param connection
   * @param user
   * @return
   * @throws Exception
   */
  int add(Connection connection, User user) throws Exception;

  /**
   * 通过条件查询-userList
   *
   * @param connection
   * @param userName
   * @param userRole
   * @return
   * @throws Exception
   */
  List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize) throws Exception;

  /**
   * 通过条件查询-用户表记录数
   *
   * @param connection
   * @param userName
   * @param userRole
   * @return
   * @throws Exception
   */
  int getUserCount(Connection connection, String userName, int userRole) throws Exception;

  /**
   * 通过userId删除user
   *
   * @param delId
   * @return
   * @throws Exception
   */
  int deleteUserById(Connection connection, Integer delId) throws Exception;

  /**
   * 通过userId获取user
   *
   * @param connection
   * @param id
   * @return
   * @throws Exception
   */
  User getUserById(Connection connection, String id) throws Exception;

  /**
   * 修改用户信息
   *
   * @param connection
   * @param user
   * @return
   * @throws Exception
   */
  int modify(Connection connection, User user) throws Exception;

  /**
   * 修改当前用户密码
   *
   * @param connection
   * @param id
   * @param pwd
   * @return
   * @throws Exception
   */
  int updatePwd(Connection connection, int id, String pwd) throws Exception;
}
