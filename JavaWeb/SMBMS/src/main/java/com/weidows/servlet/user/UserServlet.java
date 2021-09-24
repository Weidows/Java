package com.weidows.servlet.user;


import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.weidows.pojo.Role;
import com.weidows.pojo.User;
import com.weidows.service.role.RoleService;
import com.weidows.service.role.RoleServiceImpl;
import com.weidows.service.user.UserService;
import com.weidows.service.user.UserServiceImpl;
import com.weidows.util.Constants;
import com.weidows.util.PageSupport;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//实现servlet复用
@WebServlet("/jsp/user.do")
public class UserServlet extends HttpServlet {

  private static final long serialVersionUID = 444208147286197100L;

  @Override
  public void destroy() {
    super.destroy();
  }

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request, response);
  }

  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String method = request.getParameter("method");

    System.out.println("method----> " + method);

    if (method != null && method.equals("add")) {
      //增加操作
      this.add(request, response);
    } else if (method != null && method.equals("query")) {
      this.query(request, response);
    } else if (method != null && method.equals("getrolelist")) {
      this.getRoleList(request, response);
    } else if (method != null && method.equals("ucexist")) {
      this.userCodeExist(request, response);
    } else if (method != null && method.equals("deluser")) {
      this.delUser(request, response);
    } else if (method != null && method.equals("view")) {
      this.getUserById(request, response, "userview.jsp");
    } else if (method != null && method.equals("modify")) {
      this.getUserById(request, response, "usermodify.jsp");
    } else if (method != null && method.equals("modifyexe")) {
      this.modify(request, response);
    } else if (method != null && method.equals("pwdmodify")) {
      this.getPwdByUserId(request, response);
    } else if (method != null && method.equals("savepwd")) {
      this.updatePwd(request, response);
    }

  }


  private void updatePwd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    Object o = request.getSession().getAttribute(Constants.USER_SESSION);
    String newpassword = request.getParameter("newpassword");
    if (o != null && !StringUtils.isNullOrEmpty(newpassword)) {
      UserService userService = new UserServiceImpl();
      boolean flag = userService.updatePwd(((User) o).getId(), newpassword);
      if (flag) {
        request.setAttribute(Constants.SYS_MESSAGE, "修改密码成功,请退出并使用新密码重新登录！");
        request.getSession().removeAttribute(Constants.USER_SESSION);//session注销
      } else {
        request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
      }
    } else {
      request.setAttribute(Constants.SYS_MESSAGE, "修改密码失败！");
    }
    //修改成功后转发就行了
    request.getRequestDispatcher("/jsp/pwdmodify.jsp").forward(request, response);
  }


  //通过ajax验证旧密码，到session拿即可
  private void getPwdByUserId(HttpServletRequest request, HttpServletResponse response) throws IOException {
    Object o = request.getSession().getAttribute(Constants.USER_SESSION);
    String oldpassword = request.getParameter("oldpassword");
    Map<String, String> resultMap = new HashMap<>();

    if (null == o) {//session过期
      resultMap.put("result", "sessionerror");
    } else if (StringUtils.isNullOrEmpty(oldpassword)) {//旧密码输入为空
      resultMap.put("result", "error");
    } else {
      String sessionPwd = ((User) o).getUserPassword();
      if (oldpassword.equals(sessionPwd)) {
        resultMap.put("result", "true");
      } else {//旧密码输入不正确
        resultMap.put("result", "false");
      }
    }

    response.setContentType("application/json");
    PrintWriter outPrintWriter = response.getWriter();
    outPrintWriter.write(JSONArray.toJSONString(resultMap));
    outPrintWriter.flush();
    outPrintWriter.close();
  }


  private void modify(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String id = request.getParameter("uid");
    String userName = request.getParameter("userName");
    String gender = request.getParameter("gender");
    String birthday = request.getParameter("birthday");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    String userRole = request.getParameter("userRole");

    User user = new User();
    user.setId(Integer.valueOf(id));
    user.setUserName(userName);
    user.setGender(Integer.valueOf(gender));
    try {
      user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    user.setPhone(phone);
    user.setAddress(address);
    user.setUserRole(Integer.valueOf(userRole));
    user.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
    user.setModifyDate(new Date());

    UserService userService = new UserServiceImpl();
    if (userService.modify(user)) {
      response.sendRedirect(request.getContextPath() + "/jsp/user.do?method=query");
    } else {
      request.getRequestDispatcher("usermodify.jsp").forward(request, response);
    }

  }

  private void getUserById(HttpServletRequest request, HttpServletResponse response, String url)
      throws ServletException, IOException {
    String id = request.getParameter("uid");
    if (!StringUtils.isNullOrEmpty(id)) {
      //调用后台方法得到user对象
      UserService userService = new UserServiceImpl();
      User user = userService.getUserById(id);
      request.setAttribute("user", user);
      request.getRequestDispatcher(url).forward(request, response);
    }

  }

  private void delUser(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String id = request.getParameter("uid");
    Integer delId = null;
    try {
      delId = Integer.parseInt(id);
    } catch (Exception e) {
      delId = 0;
    }
    HashMap<String, String> resultMap = new HashMap<>();
    if (delId <= 0) {
      resultMap.put("delResult", "notexist");
    } else {
      UserService userService = new UserServiceImpl();
      if (userService.deleteUserById(delId)) {
        resultMap.put("delResult", "true");
      } else {
        resultMap.put("delResult", "false");
      }
    }

    //把resultMap转换成json对象输出
    response.setContentType("application/json");
    PrintWriter outPrintWriter = response.getWriter();
    outPrintWriter.write(JSONArray.toJSONString(resultMap));
    outPrintWriter.flush();
    outPrintWriter.close();
  }


  private void userCodeExist(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    //判断用户账号是否可用
    String userCode = request.getParameter(Constants.USER_NAME);

    HashMap<String, String> resultMap = new HashMap<>();
    if (StringUtils.isNullOrEmpty(userCode)) {
      //userCode == null || userCode.equals("")
      resultMap.put("userCode", "exist");
    } else {
      UserService userService = new UserServiceImpl();
      User user = userService.selectUserCodeExist(userCode);
      if (null != user) {
        resultMap.put("userCode", "exist");
      } else {
        resultMap.put("userCode", "notexist");
      }
    }

    //把resultMap转为json字符串以json的形式输出
    //配置上下文的输出类型
    response.setContentType("application/json");
    //从response对象中获取往外输出的writer对象
    PrintWriter outPrintWriter = response.getWriter();
    //把resultMap转为json字符串 输出
    outPrintWriter.write(JSONArray.toJSONString(resultMap));
    outPrintWriter.flush();//刷新
    outPrintWriter.close();//关闭流
  }

  private void getRoleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<Role> roleList = null;
    RoleService roleService = new RoleServiceImpl();
    roleList = roleService.getRoleList();
    //把roleList转换成json对象输出
    response.setContentType("application/json");
    PrintWriter outPrintWriter = response.getWriter();
    outPrintWriter.write(JSONArray.toJSONString(roleList));
    outPrintWriter.flush();
    outPrintWriter.close();
  }

  private void query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //查询用户列表
    //从前端获取数据
    String queryUserName = request.getParameter("queryname");
    String temp = request.getParameter("queryUserRole");
    String pageIndex = request.getParameter("pageIndex");
    int queryUserRole = 0;
    UserService userService = new UserServiceImpl();
    List<User> userList = null;
    //第一次走这个请求，一定是第一页，页面大小是固定的
    //设置页面容量
    int pageSize = Constants.pageSize;
    //默认当前页码
    int currentPageNo = 1;

    if (queryUserName == null) {
      queryUserName = "";
    }
    if (temp != null && !temp.equals("")) {
      queryUserRole = Integer.parseInt(temp);
    }

    if (pageIndex != null) {
      try {
        currentPageNo = Integer.parseInt(pageIndex);
      } catch (NumberFormatException e) {
        response.sendRedirect("error.jsp");
      }
    }
    //总数量（表）
    int totalCount = userService.getUserCount(queryUserName, queryUserRole);
    //总页数
    PageSupport pages = new PageSupport();
    pages.setCurrentPageNo(currentPageNo);  //当前页
    pages.setPageSize(pageSize);            //页面大小
    pages.setTotalCount(totalCount);        //总数量

    int totalPageCount = pages.getTotalPageCount();  //总页面数量

    //控制首页和尾页
    //如果页面小于第一页，就显示第一页
    if (currentPageNo < 1) {
      currentPageNo = 1;
      //如果当前页面大于最后一页，当前页等于最后一页即可
    } else if (currentPageNo > totalPageCount) {
      currentPageNo = totalPageCount;
    }

    //获取用户列表展示
    userList = userService.getUserList(queryUserName, queryUserRole, currentPageNo, pageSize);
    request.setAttribute("userList", userList);
    //获取角色列表
    List<Role> roleList = null;
    RoleService roleService = new RoleServiceImpl();
    roleList = roleService.getRoleList();
    request.setAttribute("roleList", roleList);

    request.setAttribute("queryUserName", queryUserName);
    request.setAttribute("queryUserRole", queryUserRole);
    request.setAttribute("totalPageCount", totalPageCount);
    request.setAttribute("totalCount", totalCount);
    request.setAttribute("currentPageNo", currentPageNo);

    request.getRequestDispatcher("userlist.jsp").forward(request, response);
  }

  private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String userCode = request.getParameter("userCode");
    String userName = request.getParameter("userName");
    String userPassword = request.getParameter("userPassword");
    String gender = request.getParameter("gender");
    String birthday = request.getParameter("birthday");
    String phone = request.getParameter("phone");
    String address = request.getParameter("address");
    String userRole = request.getParameter("userRole");

    User user = new User();
    user.setUserCode(userCode);
    user.setUserName(userName);
    user.setUserPassword(userPassword);
    user.setAddress(address);
    try {
      user.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
    } catch (ParseException e) {
      e.printStackTrace();
    }
    user.setGender(Integer.valueOf(gender));
    user.setPhone(phone);
    user.setUserRole(Integer.valueOf(userRole));
    user.setCreationDate(new Date());
    user.setCreatedBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());

    UserService userService = new UserServiceImpl();
    if (userService.add(user)) {
      response.sendRedirect(request.getContextPath() + "/jsp/user.do?method=query");
    } else {
      request.getRequestDispatcher("useradd.jsp").forward(request, response);
    }

  }

  /**
   * Initialization of the servlet. <br>
   */
  @Override
  public void init() {
    // Put your code here
  }

}
