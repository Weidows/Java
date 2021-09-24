/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-24 15:56:06
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-24 16:57:36
 * @FilePath: \Weidows\JavaWeb\demo-1\src\main\java\com\weidows\HelloServlet.java
 * @Description:
 * @!: *********************************************************************
 */
package com.weidows;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = -6617893791621340358L;

  //get或者post只是请求实现的不同的方式，可以相互调用，业务逻辑都一样；

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    //ServletOutputStream outputStream = resp.getOutputStream();
    PrintWriter writer = resp.getWriter(); //响应流
    writer.print("Hello,Servlet");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
