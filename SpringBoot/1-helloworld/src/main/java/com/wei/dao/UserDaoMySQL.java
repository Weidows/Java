/*
 * @Author: Weidows
 * @Date: 2020-11-07 10:49:38
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 10:52:14
 * @FilePath: \SpringBoot\Spring-1\src\main\java\com\wei\dao\UserDaoMySQL.java
 * @Description:
 */
package com.wei.dao;

public class UserDaoMySQL implements UserDao {

  @Override
  public void getUser() {
    System.out.println("MySQL获取用户数据.");
  }

}
