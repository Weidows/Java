/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-29 09:17:55
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-29 09:19:16
 * @FilePath: \Weidows\JavaWeb\demo-3\src\main\java\servlet\ImageServlet.java
 * @Description:
 * @!: *********************************************************************
 */
package servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

public class ImageServlet extends HttpServlet {

  /**
   *
   */
  private static final long serialVersionUID = 4590298452958016399L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //如何让浏览器3秒自动刷新一次;
    resp.setHeader("refresh", "3");

    //在内存中创建一个图片
    BufferedImage image = new BufferedImage(80, 20, BufferedImage.TYPE_INT_RGB);

    //得到图片
    Graphics2D graphics = (Graphics2D) image.getGraphics(); //笔

    //设置图片的背景颜色
    graphics.setColor(Color.white);
    graphics.fillRect(0, 0, 80, 20);

    //给图片写数据
    graphics.setColor(Color.BLUE);
    graphics.setFont(new Font(null, Font.BOLD, 20));
    graphics.drawString(makeNum(), 0, 20);

    //告诉浏览器，这个请求用图片的方式打开
    resp.setContentType("image/jpeg");

    //网站存在缓存，不让浏览器缓存
    resp.setDateHeader("expires", -1);
    resp.setHeader("Cache-Control", "no-cache");
    resp.setHeader("Pragma", "no-cache");

    //把图片写给浏览器
    ImageIO.write(image, "jpg", resp.getOutputStream());
  }

  //生成随机数
  private String makeNum() {
    Random random = new Random();
    String num = random.nextInt(9999999) + "";
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < 7 - num.length(); i++) {
      sb.append("0");
    }
    num = sb.toString() + num;
    return num;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
