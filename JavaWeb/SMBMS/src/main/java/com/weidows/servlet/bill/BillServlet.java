package com.weidows.servlet.bill;


import com.alibaba.fastjson.JSONArray;
import com.mysql.cj.util.StringUtils;
import com.weidows.pojo.Bill;
import com.weidows.pojo.Provider;
import com.weidows.pojo.User;
import com.weidows.service.bill.BillService;
import com.weidows.service.bill.BillServiceImpl;
import com.weidows.service.provider.ProviderService;
import com.weidows.service.provider.ProviderServiceImpl;
import com.weidows.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@WebServlet("/jsp/bill.do")
public class BillServlet extends HttpServlet {

  private static final long serialVersionUID = -1898446683172394681L;

  /**
   * Destruction of the servlet. <br>
   */
  @Override
  public void destroy() {
    super.destroy(); // Just puts "destroy" string in log
    // Put your code here
  }

  /**
   * The doGet method of the servlet. <br>
   * <p>
   * This method is called when a form has its tag value method equals to get.
   *
   * @param request  the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException      if an error occurred
   */
  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doPost(request, response);
  }

  /**
   * The doPost method of the servlet. <br>
   * <p>
   * This method is called when a form has its tag value method equals to post.
   *
   * @param request  the request send by the client to the server
   * @param response the response send by the server to the client
   * @throws ServletException if an error occurred
   * @throws IOException      if an error occurred
   */
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String method = request.getParameter("method");
    if (method != null && method.equals("query")) {
      this.query(request, response);
    } else if (method != null && method.equals("add")) {
      this.add(request, response);
    } else if (method != null && method.equals("view")) {
      this.getBillById(request, response, "billview.jsp");
    } else if (method != null && method.equals("modify")) {
      this.getBillById(request, response, "billmodify.jsp");
    } else if (method != null && method.equals("modifysave")) {
      this.modify(request, response);
    } else if (method != null && method.equals("delbill")) {
      this.delBill(request, response);
    } else if (method != null && method.equals("getproviderlist")) {
      this.getProviderlist(request, response);
    }

  }

  private void getProviderlist(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    System.out.println("getproviderlist ========================= ");
    List<Provider> providerList;
    ProviderService providerService = new ProviderServiceImpl();
    providerList = providerService.getProviderList("", "");
    //把providerList转换成json对象输出
    response.setContentType("application/json");
    PrintWriter outPrintWriter = response.getWriter();
    outPrintWriter.write(JSONArray.toJSONString(providerList));
    outPrintWriter.flush();
    outPrintWriter.close();
  }

  private void getBillById(HttpServletRequest request, HttpServletResponse response, String url)
      throws ServletException, IOException {
    String id = request.getParameter("billid");
    if (!StringUtils.isNullOrEmpty(id)) {
      BillService billService = new BillServiceImpl();
      Bill bill;
      bill = billService.getBillById(id);
      request.setAttribute("bill", bill);
      request.getRequestDispatcher(url).forward(request, response);
    }
  }

  private void modify(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    System.out.println("modify===============");

    String id = request.getParameter("id");
    String productName = request.getParameter("productName");
    String productDesc = request.getParameter("productDesc");
    String productUnit = request.getParameter("productUnit");
    String productCount = request.getParameter("productCount");
    String totalPrice = request.getParameter("totalPrice");
    String providerId = request.getParameter("providerId");
    String isPayment = request.getParameter("isPayment");

    Bill bill = new Bill();
    bill.setId(Integer.valueOf(id));
    bill.setProductName(productName);
    bill.setProductDesc(productDesc);
    bill.setProductUnit(productUnit);
    bill.setProductCount(new BigDecimal(productCount).setScale(2, BigDecimal.ROUND_DOWN));
    bill.setIsPayment(Integer.parseInt(isPayment));
    bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2, BigDecimal.ROUND_DOWN));
    bill.setProviderId(Integer.parseInt(providerId));

    bill.setModifyBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
    bill.setModifyDate(new Date());
    boolean flag;
    BillService billService = new BillServiceImpl();
    flag = billService.modify(bill);
    if (flag) {
      response.sendRedirect(request.getContextPath() + "/jsp/bill.do?method=query");
    } else {
      request.getRequestDispatcher("billmodify.jsp").forward(request, response);
    }
  }

  private void delBill(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    String id = request.getParameter("billid");
    HashMap<String, String> resultMap = new HashMap<>();
    if (!StringUtils.isNullOrEmpty(id)) {
      BillService billService = new BillServiceImpl();
      boolean flag = billService.deleteBillById(id);
      if (flag) {//删除成功
        resultMap.put("delResult", "true");
      } else {//删除失败
        resultMap.put("delResult", "false");
      }
    } else {
      resultMap.put("delResult", "notexit");
    }
    //把resultMap转换成json对象输出
    response.setContentType("application/json");
    PrintWriter outPrintWriter = response.getWriter();
    outPrintWriter.write(JSONArray.toJSONString(resultMap));
    outPrintWriter.flush();
    outPrintWriter.close();
  }

  private void add(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String billCode = request.getParameter("billCode");
    String productName = request.getParameter("productName");
    String productDesc = request.getParameter("productDesc");
    String productUnit = request.getParameter("productUnit");

    String productCount = request.getParameter("productCount");
    String totalPrice = request.getParameter("totalPrice");
    String providerId = request.getParameter("providerId");
    String isPayment = request.getParameter("isPayment");

    Bill bill = new Bill();
    bill.setBillCode(billCode);
    bill.setProductName(productName);
    bill.setProductDesc(productDesc);
    bill.setProductUnit(productUnit);
    bill.setProductCount(new BigDecimal(productCount).setScale(2, BigDecimal.ROUND_DOWN));
    bill.setIsPayment(Integer.parseInt(isPayment));
    bill.setTotalPrice(new BigDecimal(totalPrice).setScale(2, BigDecimal.ROUND_DOWN));
    bill.setProviderId(Integer.parseInt(providerId));
    bill.setCreatedBy(((User) request.getSession().getAttribute(Constants.USER_SESSION)).getId());
    bill.setCreationDate(new Date());
    boolean flag;
    BillService billService = new BillServiceImpl();
    flag = billService.add(bill);
    System.out.println("add flag -- > " + flag);
    if (flag) {
      response.sendRedirect(request.getContextPath() + "/jsp/bill.do?method=query");
    } else {
      request.getRequestDispatcher("billadd.jsp").forward(request, response);
    }
  }

  private void query(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    List<Provider> providerList;
    ProviderService providerService = new ProviderServiceImpl();
    providerList = providerService.getProviderList("", "");
    request.setAttribute("providerList", providerList);

    String queryProductName = request.getParameter("queryProductName");
    String queryProviderId = request.getParameter("queryProviderId");
    String queryIsPayment = request.getParameter("queryIsPayment");
    if (StringUtils.isNullOrEmpty(queryProductName)) {
      queryProductName = "";
    }

    List<Bill> billList;
    BillService billService = new BillServiceImpl();
    Bill bill = new Bill();
    if (StringUtils.isNullOrEmpty(queryIsPayment)) {
      bill.setIsPayment(0);
    } else {
      bill.setIsPayment(Integer.parseInt(queryIsPayment));
    }

    if (StringUtils.isNullOrEmpty(queryProviderId)) {
      bill.setProviderId(0);
    } else {
      bill.setProviderId(Integer.parseInt(queryProviderId));
    }
    bill.setProductName(queryProductName);
    billList = billService.getBillList(bill);
    request.setAttribute("billList", billList);
    request.setAttribute("queryProductName", queryProductName);
    request.setAttribute("queryProviderId", queryProviderId);
    request.setAttribute("queryIsPayment", queryIsPayment);
    request.getRequestDispatcher("billlist.jsp").forward(request, response);

  }

  public static void main(String[] args) {
    System.out.println(new BigDecimal("23.235").setScale(2, BigDecimal.ROUND_HALF_DOWN));
  }

  /**
   * Initialization of the servlet. <br>
   */
  @Override
  public void init() {
    // Put your code here
  }

}
