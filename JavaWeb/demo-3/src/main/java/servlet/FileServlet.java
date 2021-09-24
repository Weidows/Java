/*
 * @?: *********************************************************************
 * @Author: Weidows
 * @Date: 2021-03-28 00:32:39
 * @LastEditors: Weidows
 * @LastEditTime: 2021-03-29 00:17:15
 * @FilePath: \Weidows\JavaWeb\demo-3\src\main\java\servlet\FileServlet.java
 * @Description:
 * @!: *********************************************************************
 */
package servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileServlet extends HttpServlet {
  /**
   *
   */
  private static final long serialVersionUID = -2643615496012694161L;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // 1. 要获取下载文件的路径
    String realPath = this.getServletContext().getRealPath("/WEB-INF/classes/test.txt");
    System.out.println("下载文件的路径：" + realPath);

    // 2. 下载的文件名
    String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
    System.out.println("文件名: " + fileName);

    // 3. 设置想办法让浏览器能够支持(Content-Disposition)下载我们需要的东西,中文文件名URLEncoder.encode编码，否则有可能乱码
    resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));

    // 4. 获取下载文件的输入流
    FileInputStream in = new FileInputStream(realPath);

    // 5. 创建缓冲区
    int len = 0;
    byte[] buffer = new byte[1024];

    // 6. 获取OutputStream对象
    ServletOutputStream out = resp.getOutputStream();

    // 7. 将FileOutputStream流写入到buffer缓冲区,使用OutputStream将缓冲区中的数据输出到客户端！
    while ((len = in.read(buffer)) > 0) {
      out.write(buffer, 0, len);
    }

    // 8. 关闭连接
    in.close();
    out.close();
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    doGet(req, resp);
  }
}
