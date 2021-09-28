/*
 * @Author: Weidows
 * @Date: 2020-11-07 10:52:55
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 16:40:48
 * @FilePath: \SpringBoot\Spring-1\src\main\java\com\wei\dao\UserDaoOracle.java
 * @Description:
 */
package com.wei.dao;

public class UserDaoOracle implements UserDao {

  @Override
  public void getUser() {
    System.out.println("Oralce获取用户数据.");

  }
}
