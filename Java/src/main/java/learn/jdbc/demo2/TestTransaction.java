/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-21 11:08:40
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-21 11:17:33
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\jdbc\demo2\TestTransaction.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.jdbc.demo2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import learn.jdbc.demo2.utils.JDBCUtils;

public class TestTransaction {
  private static Connection connection = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;

  public static void main(String[] args) throws SQLException {
    try {
      connection = JDBCUtils.getConnection();
      //关闭数据库的自动提交功能,同时开启事务
      connection.setAutoCommit(false);

      String sql = "update account set money = money-500 where id = 1";
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.executeUpdate();

      String sql2 = "update account set money = money-500 where id = 2";
      preparedStatement = connection.prepareStatement(sql2);
      preparedStatement.executeUpdate();

      //业务完毕，提交事务
      connection.commit();
      System.out.println("事务操作成功");
    } catch (Exception e) {
      //如果失败，默认会回滚,也可以在这里自定义
      connection.rollback();
      e.printStackTrace();
    } finally {
      JDBCUtils.releaseConnection(connection, preparedStatement, resultSet);
    }
  }
}
