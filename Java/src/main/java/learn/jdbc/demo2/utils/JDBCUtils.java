/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-20 11:28:03
 * @LastEditors: Weidows
 * @LastEditTime: 2021-04-22 09:22:11
 * @Description:
 * @!: *********************************************************************
 */

package learn.jdbc.demo2.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
  private static String driver = null;
  private static String url = null;
  private static String username = null;
  private static String password = null;

  static {
    // 加载连接信息
    Properties properties = new Properties();
    try {
      properties.load(new FileInputStream("Java/src/main/java/twenty_one/jdbc/demo2/db.properties"));

      driver = properties.getProperty("driver");
      url = properties.getProperty("url");
      username = properties.getProperty("username");
      password = properties.getProperty("password");

      Class.forName(driver);
    } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }

  // 获取连接
  public static Connection getConnection() throws SQLException {
    return DriverManager.getConnection(url, username, password);
  }

  // 释放资源
  public static void releaseConnection(Connection connection,Statement statement,ResultSet resultSet) throws SQLException {
    if (resultSet != null) {
      resultSet.close();
    }
    if (statement != null) {
      statement.close();
    }
    if (connection != null) {
      connection.close();
    }
  }
}
