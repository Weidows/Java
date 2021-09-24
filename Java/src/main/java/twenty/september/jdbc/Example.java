/*
 * @Author: Weidows
 * @Date: 2020-09-21 16:50:33
 * @LastEditors: Weidows
 * @LastEditTime: 2020-09-23 19:51:02
 * @FilePath: \Weidows\Java\src\main\java\twenty\september\jdbc\Example.java
 */
package twenty.september.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Example {
  public static void main(String[] args) throws SQLException {
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;
    try {
      //1.加载数据库驱动
      Class.forName("com.mysql.jdbc.Driver");
      //2.通过DriverManager获取数据库连接
      String url = "jdbc:mysql:localhost:3306/jdbc";
      String username = "root";
      String password = "root";
      conn = DriverManager.getConnection(url, username, password);
      //3.通过Connection对象获取Statement对象
      stmt = conn.createStatement();
      //4.使用Statement执行SQL语句
      String sql = "select * from tb_user";
      rs = stmt.executeQuery(sql);
      //5.操作ResultSet结果集
      System.out.println("id\t name\t sex\t email\t birthday");
      while (rs.next()) {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String sex = rs.getString("sex");
        String email = rs.getString("email");
        Date birthday = rs.getDate("birthday");
        System.out.println(id + "\t" + name + "\t" + sex + "\t" + email + "\t" + birthday);
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      //6.关闭连接,释放资源
      if (rs != null) {
        rs.close();
      }
      if (stmt != null) {
        stmt.close();
      }
      if (conn != null) {
        conn.close();
      }
    }
  }
}
