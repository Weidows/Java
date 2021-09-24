package com.weidows.dao.provider;


import com.mysql.cj.util.StringUtils;
import com.weidows.dao.BaseDao;
import com.weidows.pojo.Provider;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProviderDaoImpl implements ProviderDao {

  @Override
  public int add(Connection connection, Provider provider)
      throws Exception {
    int flag = 0;
    if (null != connection) {
      String sql = "insert into smbms_provider (proCode,proName,proDesc," +
          "proContact,proPhone,proAddress,proFax,createdBy,creationDate) " +
          "values(?,?,?,?,?,?,?,?,?)";
      Object[] params = {provider.getProCode(), provider.getProName(), provider.getProDesc(),
          provider.getProContact(), provider.getProPhone(), provider.getProAddress(),
          provider.getProFax(), provider.getCreatedBy(), provider.getCreationDate()};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public List<Provider> getProviderList(Connection connection, String proName, String proCode)
      throws Exception {
    List<Provider> providerList = new ArrayList<>();
    if (connection != null) {
      StringBuilder sqlBuilder = new StringBuilder();
      sqlBuilder.append("select * from smbms_provider where 1=1 ");
      List<Object> list = new ArrayList<>();
      if (!StringUtils.isNullOrEmpty(proName)) {
        sqlBuilder.append(" and proName like ?");
        list.add("'" + proName + "'");
      }
      if (!StringUtils.isNullOrEmpty(proCode)) {
        sqlBuilder.append(" and proCode like ?");
        list.add("'" + proCode + "'");
      }
      Object[] params = list.toArray();
      String sql = sqlBuilder.toString();
      System.out.println("sql ----> " + sql);
      ResultSet rs = BaseDao.execute(connection, null, sql, params);
      while (rs.next()) {
        Provider _provider = new Provider();
        setData(rs, _provider);
        _provider.setCreationDate(rs.getTimestamp("creationDate"));
        providerList.add(_provider);
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return providerList;
  }

  private void setData(ResultSet rs, Provider _provider) throws SQLException {
    _provider.setId(rs.getInt("id"));
    _provider.setProCode(rs.getString("proCode"));
    _provider.setProName(rs.getString("proName"));
    _provider.setProDesc(rs.getString("proDesc"));
    _provider.setProContact(rs.getString("proContact"));
    _provider.setProPhone(rs.getString("proPhone"));
    _provider.setProAddress(rs.getString("proAddress"));
    _provider.setProFax(rs.getString("proFax"));
  }

  @Override
  public int deleteProviderById(Connection connection, String delId) throws SQLException {
    int flag = 0;
    if (null != connection) {
      String sql = "delete from smbms_provider where id=?";
      Object[] params = {delId};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }

  @Override
  public Provider getProviderById(Connection connection, String id)
      throws Exception {
    Provider provider = null;
    ResultSet rs = null;
    if (null != connection) {
      String sql = "select * from smbms_provider where id=?";
      Object[] params = {id};
      rs = BaseDao.execute(connection, null, sql, params);
      if (rs.next()) {
        provider = new Provider();
        setData(rs, provider);
        provider.setCreatedBy(rs.getInt("createdBy"));
        provider.setCreationDate(rs.getTimestamp("creationDate"));
        provider.setModifyBy(rs.getInt("modifyBy"));
        provider.setModifyDate(rs.getTimestamp("modifyDate"));
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, rs);
    }
    return provider;
  }

  @Override
  public int modify(Connection connection, Provider provider)
      throws Exception {
    int flag = 0;
    if (null != connection) {
      String sql = "update smbms_provider set proName=?,proDesc=?,proContact=?," +
          "proPhone=?,proAddress=?,proFax=?,modifyBy=?,modifyDate=? where id = ? ";
      Object[] params = {provider.getProName(), provider.getProDesc(), provider.getProContact(), provider.getProPhone(), provider.getProAddress(),
          provider.getProFax(), provider.getModifyBy(), provider.getModifyDate(), provider.getId()};
      flag = BaseDao.execute(connection, sql, params);
      BaseDao.closeResource(null, BaseDao.preparedStatement, null);
    }
    return flag;
  }
}
