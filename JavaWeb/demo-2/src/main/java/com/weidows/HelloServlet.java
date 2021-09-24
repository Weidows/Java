/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-26 08:43:04
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-26 11:45:39
 * @FilePath: \Weidows\JavaWeb\demo-2\src\main\java\com\weidows\HelloServlet.java
 * @Description:
 * @!: *********************************************************************
 */
package com.weidows;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServletContext context = this.getServletContext();
    String username = "齐下无贰"; //数据
    context.setAttribute("username", username); //将一个数据保存在了ServletContext中，名字为：username 。值 username
    System.out.println("username 属性已设置.");
  }
}
