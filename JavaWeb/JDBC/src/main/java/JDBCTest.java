import com.mysql.jdbc.Driver;

import java.sql.*;

public class JDBCTest {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    //0.配置信息
    String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
    String username = "root";
    String password = "123456";

    //1.加载驱动
    DriverManager.registerDriver(new Driver());

    //2.连接数据库,代表数据库
    Connection connection = DriverManager.getConnection(url, username, password);

    //3.向数据库发送SQL的对象Statement,PreparedStatement : CRUD
    Statement statement = connection.createStatement();

    //4.编写SQL
    String sql = "select * from users";

    //5.执行查询SQL，返回一个 ResultSet  ： 结果集
    ResultSet rs = statement.executeQuery(sql);

    while (rs.next()) {
      System.out.println("id=" + rs.getObject("id"));
      System.out.println("name=" + rs.getObject("name"));
      System.out.println("password=" + rs.getObject("password"));
      System.out.println("email=" + rs.getObject("email"));
      System.out.println("birthday=" + rs.getObject("birthday"));
    }

    //6.关闭连接，释放资源（一定要做） 先开后关
    rs.close();
    statement.close();
    connection.close();
  }
}