package com.weidows.service.provider;

import com.weidows.dao.BaseDao;
import com.weidows.dao.bill.BillDao;
import com.weidows.dao.bill.BillDaoImpl;
import com.weidows.dao.provider.ProviderDao;
import com.weidows.dao.provider.ProviderDaoImpl;
import com.weidows.pojo.Provider;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class ProviderServiceImpl implements ProviderService {

  private Connection connection = null;
  private ProviderDao providerDao = null;
  private BillDao billDao = null;

  public ProviderServiceImpl() {
    providerDao = new ProviderDaoImpl();
    billDao = new BillDaoImpl();
  }

  @Override
  public boolean add(Provider provider) {
    boolean flag = false;
    try {
      connection = BaseDao.getConnection();
      connection.setAutoCommit(false);//开启JDBC事务管理
      if (providerDao.add(connection, provider) > 0)
        flag = true;
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
    return flag;
  }

  @Override
  public List<Provider> getProviderList(String proName, String proCode) {
    List<Provider> providerList = null;
    System.out.println("query proName ---- > " + proName);
    System.out.println("query proCode ---- > " + proCode);
    try {
      connection = BaseDao.getConnection();
      providerList = providerDao.getProviderList(connection, proName, proCode);
    } catch (Exception e) {
      e.printStackTrace();
      providerList = null;
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return providerList;
  }

  /**
   * 业务：根据ID删除供应商表的数据之前，需要先去订单表里进行查询操作
   * <ul>
   *  <li>若订单表中无该供应商的订单数据，则可以删除</li>
   *  <li>若有该供应商的订单数据，则不可以删除</li>
   * </ul>
   *
   * <hr>
   *
   * 返回值billCount
   * <ul>
   *  <li>1> billCount == 0  可以删除 成功（0）/ 不成功（-1）</li>
   *  <li>2> billCount > 0   不能删除 查询成功（0）查询不成功（-1）</li>
   * </ul>
   *
   * <hr>
   *
   * 判断
   * <ul>
   *  <li>如果billCount = -1 失败</li>
   *  <li>若billCount >= 0 成功</li>
   * </ul>
   */
  @Override
  public int deleteProviderById(String providerId) {
    int billCount = -1;
    try {
      connection = BaseDao.getConnection();
      connection.setAutoCommit(false);
      billCount = billDao.getBillCountByProviderId(connection, providerId);
      if (billCount == 0) {
        providerDao.deleteProviderById(connection, providerId);
      }
      connection.commit();
    } catch (Exception e) {
      e.printStackTrace();
      billCount = -1;
      try {
        connection.rollback();
      } catch (SQLException e1) {
        e1.printStackTrace();
      }
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return billCount;
  }

  @Override
  public Provider getProviderById(String id) {
    Provider provider = null;
    try {
      connection = BaseDao.getConnection();
      provider = providerDao.getProviderById(connection, id);
    } catch (Exception e) {
      e.printStackTrace();
      provider = null;
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return provider;
  }

  @Override
  public boolean modify(Provider provider) {
    boolean flag = false;
    try {
      connection = BaseDao.getConnection();
      if (providerDao.modify(connection, provider) > 0)
        flag = true;
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return flag;
  }

}
