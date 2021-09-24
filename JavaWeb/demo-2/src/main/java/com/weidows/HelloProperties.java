/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-26 22:53:17
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-26 23:01:19
 * @FilePath: \Weidows\JavaWeb\demo-2\src\main\java\com\weidows\HelloProperties.java
 * @Description:
 * @!: *********************************************************************
 */
package com.weidows;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloProperties extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = -437042901757770674L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Properties prop = new Properties();
    // 生成后的路径: target/demo-2/WEB-INF/classes/db.properties
    prop.load(this.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties"));

    String user = prop.getProperty("username");
    String pwd = prop.getProperty("password");

    resp.getWriter().print("username: " + user + "\npassword: " + pwd);
  }
}
