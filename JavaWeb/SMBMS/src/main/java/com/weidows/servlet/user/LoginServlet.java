package com.weidows.servlet.user;

import com.weidows.pojo.User;
import com.weidows.service.user.UserService;
import com.weidows.service.user.UserServiceImpl;
import com.weidows.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
  //servlet  ： 控制层调业务层
  private static final long serialVersionUID = -4672709233628500722L;

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    //获取用户名和密码
    String userCode = request.getParameter(Constants.USER_NAME);
    String userPassword = request.getParameter(Constants.USER_PASSWORD);
    //调用service方法，进行用户匹配
    UserService userService = new UserServiceImpl();
    User user = userService.login(userCode, userPassword);
    if (null != user) {//登录成功
      //放入session
      request.getSession().setAttribute(Constants.USER_SESSION, user);
      //页面重定向（frame.jsp）
      response.sendRedirect("jsp/frame.jsp");
    } else {
      //页面转发（login.jsp）带出提示信息--转发
      request.setAttribute("error", "用户名或密码不正确");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}
