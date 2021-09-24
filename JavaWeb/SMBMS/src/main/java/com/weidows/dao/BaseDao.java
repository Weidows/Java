package com.weidows.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * 操作数据库的基类--静态类
 */
public class BaseDao {

  private static final String driver;
  private static final String url;
  private static final String username;
  private static final String password;

  private static Connection connection = null;
  public static PreparedStatement preparedStatement = null;

  //静态代码块,在类加载的时候执行
  static {
    String configFile = "db.properties";
    InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(configFile);
    Properties properties = new Properties();
    try {
      properties.load(inputStream);
    } catch (IOException e) {
      e.printStackTrace();
    }
    driver = properties.getProperty("driver");
    url = properties.getProperty("url");
    username = properties.getProperty("username");
    password = properties.getProperty("password");
  }


  /**
   * 获取数据库连接
   *
   * @return connection
   */
  public static Connection getConnection() {
    if (connection == null) {
      try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, username, password);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    return connection;
  }

  /**
   * 查询数据库的公共操作
   *
   * @param connection
   * @param rs
   * @param sql
   * @param params
   * @return
   */
  public static ResultSet execute(Connection connection, ResultSet rs, String sql, Object[] params) throws SQLException {
    preparedStatement = connection.prepareStatement(sql);
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
    rs = preparedStatement.executeQuery();
    return rs;
  }

  /**
   * 更新数据库的公共操作
   *
   * @param connection
   * @param sql
   * @param params
   * @return
   * @throws Exception
   */
  public static int execute(Connection connection, String sql, Object[] params) throws SQLException {
    int updateRows;
    preparedStatement = connection.prepareStatement(sql);
    for (int i = 0; i < params.length; i++) {
      preparedStatement.setObject(i + 1, params[i]);
    }
    updateRows = preparedStatement.executeUpdate();
    return updateRows;
  }

  /**
   * 释放资源
   *
   * @param connection
   * @param preparedStatement
   * @param resultSet
   * @return
   */
  public static boolean closeResource(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
    boolean flag = true;
    try {
      if (resultSet != null) {
        resultSet.close();
        resultSet = null;//GC回收
      }
      if (preparedStatement != null) {
        preparedStatement.close();
        preparedStatement = null;//GC回收
      }
      if (connection != null) {
        connection.close();
        connection = null;//GC回收
      }
    } catch (SQLException e) {
      e.printStackTrace();
      flag = false;
    }
    return flag;
  }
}
