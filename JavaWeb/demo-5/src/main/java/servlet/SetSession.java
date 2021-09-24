package servlet;


import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class SetSession extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //解决乱码问题
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");

    //得到Session和writer
    HttpSession session = req.getSession();
    PrintWriter writer = resp.getWriter();

    //给Session中存东西
    session.setAttribute("person", new Person("齐下无贰", 100));

    //获取Session的ID
    String sessionId = session.getId();

    //判断Session是不是新创建
    if (session.isNew()) {
      writer.println("session创建成功,ID: " + sessionId);
    } else {
      writer.println("session已经在服务器中存在了,ID: " + sessionId);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}

class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person{" +
        "name='" + name + '\'' +
        ", age=" + age +
        '}';
  }
}
