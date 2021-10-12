/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-20 16:48:36
 * @LastEditors: Weidows
 * @LastEditTime: 2021-10-12 14:02:06
 * @FilePath: \Java\Java\src\main\java\learn\jdbc\demo2\TestCRUD.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.jdbc.demo2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import learn.jdbc.demo2.utils.JDBCUtils;

public class TestCRUD {
  private static Connection connection = null;
  private static Statement statement = null;
  private static ResultSet resultSet = null;

  public static void main(String[] args) throws SQLException {
    // 连接
    connection = JDBCUtils.getConnection();
    statement = connection.createStatement();

    // 增
    String insert = "INSERT INTO jdbcstudy.users(NAME, PASSWORD, email, birthday)  VALUES ('weidows', 123456, 'utsuko27@qq.com', '2020-07-28');";
    if (statement.executeUpdate(insert) > 0) { // 返回int:受影响的行数
      System.out.println("插入成功. insert -> weidows");
    }

    // 改
    String update = "update jdbcstudy.users set password =654321 where name = 'weidows';";
    if (statement.executeUpdate(update) > 0) {
      System.out.println("修改成功. weidows.password -> 654321");
    }

    // 查
    String query = "SELECT * From jdbcstudy.users;";
    resultSet = statement.executeQuery(query);
    while (resultSet.next()) {
      System.out.println("id = " + resultSet.getObject("id"));
      System.out.println("name = " + resultSet.getObject("NAME"));
      System.out.println("password = " + resultSet.getObject("PASSWORD"));
      System.out.println("email = " + resultSet.getObject("email"));
      System.out.println("birthday = " + resultSet.getObject("birthday"));
      System.out.println("===============================================================");
    }

    // 删
    String delete = "delete from jdbcstudy.users where name = 'weidows';";
    if (statement.executeUpdate(delete) > 0) {
      System.out.println("删除成功.");
    }

    // 断连
    JDBCUtils.releaseConnection(connection, statement, resultSet);
  }
}
