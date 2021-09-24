package com.weidows.service.bill;


import com.weidows.dao.BaseDao;
import com.weidows.dao.bill.BillDao;
import com.weidows.dao.bill.BillDaoImpl;
import com.weidows.pojo.Bill;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BillServiceImpl implements BillService {

  private Connection connection = null;
  private BillDao billDao = null;

  public BillServiceImpl() {
    billDao = new BillDaoImpl();
  }

  @Override
  public boolean add(Bill bill) {
    boolean flag = false;
    connection = BaseDao.getConnection();
    if (connection != null) {
      try {
        connection.setAutoCommit(false);//开启JDBC事务管理
        if (billDao.add(connection, bill) > 0) {
          flag = true;
        }
        connection.commit();
      } catch (Exception e) {
        e.printStackTrace();
        try {
          System.out.println("rollback==================");
          connection.rollback();
        } catch (SQLException e1) {
          e1.printStackTrace();
        }
      } finally {
        //在service层进行connection连接的关闭
        BaseDao.closeResource(connection, null, null);
      }
    }
    return flag;
  }

  @Override
  public List<Bill> getBillList(Bill bill) {
    List<Bill> billList = null;
    System.out.println("query productName ---- > " + bill.getProductName());
    System.out.println("query providerId ---- > " + bill.getProviderId());
    System.out.println("query isPayment ---- > " + bill.getIsPayment());

    try {
      connection = BaseDao.getConnection();
      billList = billDao.getBillList(connection, bill);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return billList;
  }

  @Override
  public boolean deleteBillById(String delId) {
    boolean flag = false;
    try {
      connection = BaseDao.getConnection();
      if (billDao.deleteBillById(connection, delId) > 0){
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }

  @Override
  public Bill getBillById(String id) {
    Bill bill = null;
    try {
      connection = BaseDao.getConnection();
      bill = billDao.getBillById(connection, id);
    } catch (Exception e) {
      e.printStackTrace();
      bill = null;
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return bill;
  }

  @Override
  public boolean modify(Bill bill) {
    boolean flag = false;
    try {
      connection = BaseDao.getConnection();
      if (billDao.modify(connection, bill) > 0){
        flag = true;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }
}
