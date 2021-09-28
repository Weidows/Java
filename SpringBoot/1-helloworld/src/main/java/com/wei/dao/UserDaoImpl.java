/*
 * @Author: Weidows
 * @Date: 2020-11-07 09:26:48
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 10:26:44
 * @FilePath: \SpringBoot\Spring-1\src\main\java\com\wei\dao\UserDaoimpl.java
 * @Description:
 */
package com.wei.dao;

public class UserDaoImpl implements UserDao {
  @Override
  public void getUser() {
    System.out.println("Test: 获取用户的数据");
  }
}
