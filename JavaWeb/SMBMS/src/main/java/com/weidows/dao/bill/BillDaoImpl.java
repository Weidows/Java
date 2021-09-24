package com.weidows.dao.bill;

import com.mysql.cj.util.StringUtils;
import com.weidows.dao.BaseDao;
import com.weidows.pojo.Bill;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillDaoImpl implements BillDao {

  @Override
  public int add(Connection connection, Bill bill) throws Exception {
    int flag = 0;
    String sql = "insert into smbms.smbms_bill (billCode,productName,productDesc," +
        "productUnit,productCount,totalPrice,isPayment,providerId,createdBy,creationDate) " +
        "values(?,?,?,?,?,?,?,?,?,?)";
    if (connection != null) {
      Object[] params = {bill.getBillCode(), bill.getProductName(), bill.getProductDesc(),
          bill.getProductUnit(), bill.getProductCount(), bill.getTotalPrice(), bill.getIsPayment(),
          bill.getProviderId(), bill.getCreatedBy(), bill.getCreationDate()};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, null, null);
      System.out.println("dao--------flag " + flag);
    }
    return flag;
  }

  @Override
  public List<Bill> getBillList(Connection connection, Bill bill)
      throws Exception {
    ResultSet resultSet = null;
    List<Bill> billList = new ArrayList<>();
    List<Object> list = new ArrayList<>();

    if (connection != null) {
      StringBuilder sql = new StringBuilder();
      sql.append("select b.*,p.proName as providerName from smbms_bill b, smbms_provider p where b.providerId = p.id");
      if (!StringUtils.isNullOrEmpty(bill.getProductName())) {
        sql.append(" and productName like ?");
        list.add("'" + bill.getProductName() + "'");
      }
      if (bill.getProviderId() > 0) {
        sql.append(" and providerId = ?");
        list.add(bill.getProviderId());
      }
      if (bill.getIsPayment() > 0) {
        sql.append(" and isPayment = ?");
        list.add(bill.getIsPayment());
      }
      Object[] params = list.toArray();
      resultSet = BaseDao.execute(connection, null, sql.toString(), params);
      while (resultSet.next()) {
        Bill _bill = new Bill();
        setData(resultSet, _bill);
        _bill.setCreationDate(resultSet.getTimestamp("creationDate"));
        _bill.setCreatedBy(resultSet.getInt("createdBy"));
        billList.add(_bill);
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, resultSet);
    }
    return billList;
  }

  private void setData(ResultSet rs, Bill _bill) throws SQLException {
    _bill.setId(rs.getInt("id"));
    _bill.setBillCode(rs.getString("billCode"));
    _bill.setProductName(rs.getString("productName"));
    _bill.setProductDesc(rs.getString("productDesc"));
    _bill.setProductUnit(rs.getString("productUnit"));
    _bill.setProductCount(rs.getBigDecimal("productCount"));
    _bill.setTotalPrice(rs.getBigDecimal("totalPrice"));
    _bill.setIsPayment(rs.getInt("isPayment"));
    _bill.setProviderId(rs.getInt("providerId"));
    _bill.setProviderName(rs.getString("providerName"));
  }

  @Override
  public int deleteBillById(Connection connection, String delId) throws SQLException {
    int flag = 0;
    if (null != connection) {
      String sql = "delete from smbms_bill where id=?";
      Object[] params = {delId};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public Bill getBillById(Connection connection, String id) throws Exception {
    Bill bill = null;
    ResultSet rs = null;
    if (null != connection) {
      String sql = "select b.*,p.proName as providerName from smbms_bill b, smbms_provider p " +
          "where b.providerId = p.id and b.id=?";
      Object[] params = {id};
      rs = BaseDao.execute(connection, null, sql, params);
      if (rs.next()) {
        bill = new Bill();
        setData(rs, bill);
        bill.setModifyBy(rs.getInt("modifyBy"));
        bill.setModifyDate(rs.getTimestamp("modifyDate"));
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return bill;
  }

  @Override
  public int modify(Connection connection, Bill bill) throws Exception {
    int flag = 0;
    if (null != connection) {
      String sql = "update smbms_bill set productName=?," +
          "productDesc=?,productUnit=?,productCount=?,totalPrice=?," +
          "isPayment=?,providerId=?,modifyBy=?,modifyDate=? where id = ? ";
      Object[] params = {bill.getProductName(), bill.getProductDesc(),
          bill.getProductUnit(), bill.getProductCount(), bill.getTotalPrice(), bill.getIsPayment(),
          bill.getProviderId(), bill.getModifyBy(), bill.getModifyDate(), bill.getId()};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public int getBillCountByProviderId(Connection connection, String providerId)
      throws Exception {
    int count = 0;
    ResultSet rs = null;
    if (null != connection) {
      String sql = "select count(1) as billCount from smbms_bill where" +
          "	providerId = ?";
      Object[] params = {providerId};
      rs = BaseDao.execute(connection, null, sql, params);
      if (rs.next()) {
        count = rs.getInt("billCount");
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return count;
  }
}
