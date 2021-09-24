package com.weidows.servlet.user;

import com.weidows.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/jsp/logout.do")
public class LogoutServlet extends HttpServlet {

  private static final long serialVersionUID = -5088734013104489465L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    //清除session
    request.getSession().removeAttribute(Constants.USER_SESSION);
    response.sendRedirect(request.getContextPath() + "/login.jsp");
  }
}
