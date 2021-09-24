/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-29 19:27:22
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-29 23:04:10
 * @FilePath: \Weidows\JavaWeb\demo-4\src\main\java\servlet\Login.java
 * @Description:
 * @!: *********************************************************************
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = -7958099474557186407L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("utf8");
    resp.setContentType("text/html");
    resp.setCharacterEncoding("utf8");
    PrintWriter writer = resp.getWriter();

    String username = req.getParameter("username");
    String password = req.getParameter("password");
    String[] hobbys = req.getParameterValues("hobbys");

    writer.println("username: " + username);
    writer.println("password: " + password);
    writer.println("爱好: " + Arrays.toString(hobbys));
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
