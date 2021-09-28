/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-21 16:14:02
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-21 16:15:13
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\jdbc\demo3\TestDataSource.java
 * @Description:
 * @!: *********************************************************************
 */
package twenty_one.jdbc.demo3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import twenty_one.jdbc.demo3.utils.DbcpUtils;

public class TestDataSource {
  private static Connection connection = null;
  private static PreparedStatement preparedStatement = null;
  private static ResultSet resultSet = null;

  public static void main(String[] args) throws SQLException {
    // 连接
    connection = DbcpUtils.getConnection();

    // ! 插入
    // 问号'?'为占位符
    String insert = "INSERT INTO jdbcstudy.users(NAME, PASSWORD, email, birthday)  VALUES (?,?,?,?);";
    //预编译sql
    preparedStatement = connection.prepareStatement(insert);
    //手动赋值
    preparedStatement.setString(1, "weidows");
    preparedStatement.setInt(2, 123456);
    preparedStatement.setString(3, "utsuko27@qq.com");
    preparedStatement.setDate(4, new Date(new java.util.Date().getTime()));
    // 执行
    if (preparedStatement.executeUpdate() > 0) {
      System.out.println("成功.");
    }

    // ! 查询
    String query = "SELECT * From jdbcstudy.users where name = ?;";
    preparedStatement = connection.prepareStatement(query);
    preparedStatement.setString(1, "weidows");
    resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.println("id = " + resultSet.getObject("id"));
      System.out.println("name = " + resultSet.getObject("NAME"));
      System.out.println("password = " + resultSet.getObject("PASSWORD"));
      System.out.println("email = " + resultSet.getObject("email"));
      System.out.println("birthday = " + resultSet.getObject("birthday"));
      System.out.println("===============================================================");
    }

    // 断连
    DbcpUtils.releaseConnection(connection, preparedStatement, resultSet);
  }
}