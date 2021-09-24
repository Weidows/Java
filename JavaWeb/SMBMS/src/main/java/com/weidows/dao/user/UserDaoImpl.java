package com.weidows.dao.user;


import com.mysql.cj.util.StringUtils;
import com.weidows.dao.BaseDao;
import com.weidows.pojo.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao层抛出异常，让service层去捕获处理
 *
 * @author Administrator
 */
public class UserDaoImpl implements UserDao {

  /**
   * @param resultSet
   * @return
   * @throws SQLException
   */
  private static User setData(ResultSet resultSet) throws SQLException {
    User user = new User();
    user.setId(resultSet.getInt("id"));
    user.setUserCode(resultSet.getString("userCode"));
    user.setUserName(resultSet.getString("userName"));
    user.setUserPassword(resultSet.getString("userPassword"));
    user.setGender(resultSet.getInt("gender"));
    user.setBirthday(resultSet.getDate("birthday"));
    user.setPhone(resultSet.getString("phone"));
    user.setAddress(resultSet.getString("address"));
    user.setUserRole(resultSet.getInt("userRole"));
    user.setCreatedBy(resultSet.getInt("createdBy"));
    user.setCreationDate(resultSet.getTimestamp("creationDate"));
    user.setModifyBy(resultSet.getInt("modifyBy"));
    user.setModifyDate(resultSet.getTimestamp("modifyDate"));
    return user;
  }

  /**
   * 得到要登录的用户
   *
   * @param connection
   * @param userCode
   * @return
   */
  @Override
  public User getLoginUser(Connection connection, String userCode) throws SQLException {
    User user = null;
    ResultSet resultSet = null;
    String sql = "select * from smbms.smbms_user where userCode=?";
    if (connection != null) {
      Object[] params = {userCode};
      resultSet = BaseDao.execute(connection, null, sql, params);
      if (resultSet.next()) {
        user = setData(resultSet);
      }
    }
    BaseDao.closeResource(null, BaseDao.preparedStatement, resultSet);
    return user;
  }


  @Override
  public int add(Connection connection, User user) throws SQLException {
    int updateRows = 0;
    String sql = "insert into smbms.smbms_user (userCode,userName,userPassword," +
        "userRole,gender,birthday,phone,address,creationDate,createdBy) " +
        "values(?,?,?,?,?,?,?,?,?,?)";
    if (null != connection) {
      Object[] params = {user.getUserCode(), user.getUserName(), user.getUserPassword(),
          user.getUserRole(), user.getGender(), user.getBirthday(),
          user.getPhone(), user.getAddress(), user.getCreationDate(), user.getCreatedBy()};
      updateRows = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return updateRows;
  }


  @Override
  public List<User> getUserList(Connection connection, String userName, int userRole, int currentPageNo, int pageSize)
      throws Exception {
    List<User> userList = new ArrayList<>();
    if (connection != null) {
      StringBuilder sql = new StringBuilder();
      List<Object> paramList = new ArrayList<>();
      sql.append("select u.*,r.roleName as userRoleName from smbms_user u,smbms_role r where u.userRole = r.id");

      if (!StringUtils.isNullOrEmpty(userName)) {
        sql.append(" and u.userName like ?");
        // 此处参数要替换上面问号处,因为是查询记录,无论中英文都必须加单引号"'"
        paramList.add("'" + userName + "'");
      }
      if (userRole > 0) {
        sql.append(" and u.userRole = ?");
        paramList.add(userRole);
      }

      //在mysql数据库中，分页使用 limit startIndex，pageSize ; 总数
      sql.append(" order by creationDate DESC limit ?,?");
      currentPageNo = (currentPageNo - 1) * pageSize;
      paramList.add(currentPageNo);
      paramList.add(pageSize);

      Object[] params = paramList.toArray();
      System.out.println("sql ----> " + sql.toString());
      ResultSet rs = BaseDao.execute(connection, null, sql.toString(), params);
      while (rs.next()) {
        User _user = new User();
        _user.setId(rs.getInt("id"));
        _user.setUserCode(rs.getString("userCode"));
        _user.setUserName(rs.getString("userName"));
        _user.setGender(rs.getInt("gender"));
        _user.setBirthday(rs.getDate("birthday"));
        _user.setPhone(rs.getString("phone"));
        _user.setUserRole(rs.getInt("userRole"));
        _user.setUserRoleName(rs.getString("userRoleName"));
        userList.add(_user);
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return userList;
  }

  @Override
  public int deleteUserById(Connection connection, Integer delId) throws SQLException {
    int flag = 0;
    String sql = "delete from smbms.smbms_user where id=?";
    if (null != connection) {
      Object[] params = {delId};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public User getUserById(Connection connection, String id) throws Exception {
    User user = null;
    ResultSet resultSet = null;
    String sql = "select u.*,r.roleName as userRoleName from smbms.smbms_user u,smbms.smbms_role r where u.id=? and u.userRole = r.id";
    if (null != connection) {
      Object[] params = {id};
      resultSet = BaseDao.execute(connection, (ResultSet) null, sql, params);
      if (resultSet.next()) {
        user = setData(resultSet);
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, resultSet);
    }
    return user;
  }

  @Override
  public int modify(Connection connection, User user) throws Exception {
    int flag = 0;
    String sql = "update smbms.smbms_user set userName=?," +
        "gender=?,birthday=?,phone=?,address=?,userRole=?,modifyBy=?,modifyDate=? where id = ? ";
    if (connection != null) {
      Object[] params = {user.getUserName(), user.getGender(), user.getBirthday(),
          user.getPhone(), user.getAddress(), user.getUserRole(), user.getModifyBy(),
          user.getModifyDate(), user.getId()};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  /**
   * 修改当前用户密码
   *
   * @param connection
   * @param id
   * @param pwd
   * @return
   */
  @Override
  public int updatePwd(Connection connection, int id, String pwd) throws SQLException {
    int flag = 0;
    String sql = "update smbms.smbms_user set userPassword= ? where id = ?";
    if (connection != null) {
      Object[] params = {pwd, id};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public int getUserCount(Connection connection, String userName, int userRole) throws Exception {
    ResultSet rs = null;
    int count = 0;
    if (connection != null) {
      StringBuilder sql = new StringBuilder();
      sql.append("select count(1) as count from smbms_user u,smbms_role r where u.userRole = r.id");
      //List用来储存我们的参数
      List<Object> list = new ArrayList<>();
      if (!StringUtils.isNullOrEmpty(userName)) {
        sql.append(" and u.userName like ?");
        list.add("'" + userName + "'");
      }
      if (userRole > 0) {
        sql.append(" and u.userRole = ?");
        list.add(userRole);
      }

      Object[] params = list.toArray();
      System.out.println("sql ----> " + sql.toString());
      rs = BaseDao.execute(connection, (ResultSet) null, sql.toString(), params);
      if (rs.next()) {
        count = rs.getInt("count");
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return count;
  }
}
