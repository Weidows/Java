/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-19 11:03:45
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-20 16:48:00
 * @FilePath: \Weidows\Java\src\main\java\twenty_one\jdbc\demo1\JDBCFirstDemo.java
 * @Description:
 * @!: *********************************************************************
 */
package learn.jdbc.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCFirstDemo {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    /**
     * 1.设置用户信息
        useUnicode = true 支持中文编码
        characterEncoding = utf8 设定字符集
        useSSL = true 安全连接
     */
    String url = "jdbc:mysql://localhost:3306/jdbcStudy?useUnicode = true & characterEncoding = utf8 & useSSL = true";
    String user = "root";
    String password = "123456";

    //2.加载驱动(固定写法,二选一)
    Class.forName("com.mysql.cj.jdbc.Driver");
    // DriverManager.registerDriver(new Driver());

    /**
     * 3.连接，数据库对象 Connection 代表数据库
        //事务提交
        connection.commit();
        //事务回滚
        connection.rollback();
        //数据库设置自动提交
        connection.setAutoCommit(true);
    */
    Connection connection = DriverManager.getConnection(url, user, password);

    //4.创建SQL的对象
    Statement statement = connection.createStatement();
    String sql = "SELECT * FROM users";

    //5.执行SQL的对象,查看返回结果
    ResultSet resultSet = statement.executeQuery(sql); //返回的结果集
    while (resultSet.next()) {
      System.out.println("id = " + resultSet.getObject("id"));
      System.out.println("name = " + resultSet.getObject("NAME"));
      System.out.println("password = " + resultSet.getObject("PASSWORD"));
      System.out.println("email = " + resultSet.getObject("email"));
      System.out.println("birthday = " + resultSet.getObject("birthday"));
      System.out.println("===============================================================");
    }

    //6.释放连接
    resultSet.close();
    statement.close();
    connection.close();
  }

}
