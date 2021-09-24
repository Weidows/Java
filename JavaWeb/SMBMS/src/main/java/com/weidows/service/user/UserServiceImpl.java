package com.weidows.service.user;

import com.weidows.dao.BaseDao;
import com.weidows.dao.user.UserDao;
import com.weidows.dao.user.UserDaoImpl;
import com.weidows.pojo.User;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * <p>service层捕获异常，进行事务处理</p>
 * <p>事务处理：调用不同dao的多个方法，必须使用同一个connection</p>
 * <p>事务完成之后，需要在service层进行connection的关闭，在dao层关闭PreparedStatement和ResultSet对象</p>
 *
 * @author Administrator
 */
public class UserServiceImpl implements UserService {

  //业务层调用Dao层，所以我们要引入Dao层
  private UserDao userDao = null;
  private Connection connection = null;

  public UserServiceImpl() {
    userDao = new UserDaoImpl();
    connection = BaseDao.getConnection();
  }

  @Override
  public boolean add(User user) {
    boolean flag = false;
    try {
      connection.setAutoCommit(false);//开启JDBC事务管理
      if (userDao.add(connection, user) > 0) {
        connection.commit();
        flag = true;
        System.out.println("add success!");
      } else {
        System.out.println("add failed!");
        throw new Exception();
      }
    } catch (Exception e) {
      e.printStackTrace();
      try {
        System.out.println("rollback==================");
        connection.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }


  /**
   * 用户登录实现
   *
   * @param userCode
   * @param userPassword
   * @return
   */
  @Override
  public User login(String userCode, String userPassword) {
    User user = null;
    try {
      //通过业务层调用对应的具体数据库操作
      user = userDao.getLoginUser(connection, userCode);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }

    //匹配密码
    if (user != null) {
      if (!user.getUserPassword().equals(userPassword)) {
        //密码不匹配
        user = null;
      }
    }
    //密码匹配时返回userDao对象
    return user;
  }


  @Override
  public List<User> getUserList(String queryUserName, int queryUserRole, int currentPageNo, int pageSize) {
    List<User> userList = null;
    try {
      userList = userDao.getUserList(connection, queryUserName, queryUserRole, currentPageNo, pageSize);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return userList;
  }

  @Override
  public User selectUserCodeExist(String userCode) {
    User user = null;
    try {
      user = userDao.getLoginUser(connection, userCode);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return user;
  }

  @Override
  public boolean deleteUserById(Integer delId) {
    boolean flag = false;
    try {
      if (userDao.deleteUserById(connection, delId) > 0) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }

  @Override
  public User getUserById(String id) {
    User user = null;
    try {
      user = userDao.getUserById(connection, id);
    } catch (Exception e) {
      e.printStackTrace();
      user = null;
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return user;
  }

  @Override
  public boolean modify(User user) {
    boolean flag = false;
    try {
      if (userDao.modify(connection, user) > 0) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }

  @Override
  public boolean updatePwd(int id, String pwd) {
    boolean flag = false;
    try {
      if (userDao.updatePwd(connection, id, pwd) > 0) {
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }

  @Override
  public int getUserCount(String queryUserName, int queryUserRole) {
    int count = 0;
    try {
      count = userDao.getUserCount(connection, queryUserName, queryUserRole);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return count;
  }

}
