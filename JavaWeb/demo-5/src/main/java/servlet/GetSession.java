package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class GetSession extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = -4606977948300644893L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //解决乱码问题
    req.setCharacterEncoding("UTF-8");
    resp.setCharacterEncoding("UTF-8");
    resp.setContentType("text/html");

    //得到Session和writer
    HttpSession session = req.getSession();
    PrintWriter writer = resp.getWriter();

    // 获取属性并输出
    Person person = (Person) session.getAttribute("person");
    writer.println(person);

    // 移除属性
    session.removeAttribute("name");

    //手动注销Session
    session.invalidate();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
