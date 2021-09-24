package demo.servlet;

import demo.utils.Constants;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Login extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    this.doPost(req, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String username = req.getParameter("username");
    HttpSession session = req.getSession();

    if (username.equals("admin")) {
      session.setAttribute(Constants.USER_SESSION, session.getId());
      resp.sendRedirect("/demo/sys/success.jsp");
    } else {
      resp.sendRedirect("/demo/failed.jsp");
    }
  }
}
