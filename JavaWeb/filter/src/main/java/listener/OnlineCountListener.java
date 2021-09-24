package listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

//统计网站在线人数 -> 统计session
public class OnlineCountListener implements HttpSessionListener {
  private ServletContext ctx;
  private Integer onlineCount;

  //一旦创建Session就会触发一次这个事件
  public void sessionCreated(HttpSessionEvent se) {
    initParam(se);
    ctx.setAttribute("OnlineCount", ++onlineCount);
  }

  /*
    一旦销毁Session就会触发一次这个事件
    Session销毁：
      1. 手动销毁  getSession().invalidate();
      2. 自动销毁
   */
  public void sessionDestroyed(HttpSessionEvent se) {
    initParam(se);
    ctx.setAttribute("OnlineCount", --onlineCount);
  }

  public void initParam(HttpSessionEvent se) {
    ctx = se.getSession().getServletContext();
    onlineCount = (Integer) ctx.getAttribute("OnlineCount");

    if (onlineCount == null) {
      ctx.setAttribute("OnlineCount", 0);
    }
  }
}
