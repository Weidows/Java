/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-21 15:57:52
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-21 16:26:22
 * @Description:
 * @!: *********************************************************************
 */
package learn.jdbc.demo3.utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class DbcpUtils {
  private static Properties properties = new Properties();
  private static DataSource dataSource = null;

  static {
    // 加载连接信息
    try {
      properties.load(new FileInputStream("Java/src/main/java/twenty_one/jdbc/demo3/db.properties"));
      dataSource = BasicDataSourceFactory.createDataSource(properties);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 获取连接
  public static Connection getConnection() throws SQLException {
    return dataSource.getConnection();
  }

  // 释放资源
  public static void releaseConnection(Connection connection, Statement statement, ResultSet resultSet)
      throws SQLException {
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
