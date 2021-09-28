package com.wei.dao;

public class UserDaoSQLServer implements UserDao {

  @Override
  public void getUser() {
    System.out.println("SQLServer获取用户数据.");
  }
  
}
