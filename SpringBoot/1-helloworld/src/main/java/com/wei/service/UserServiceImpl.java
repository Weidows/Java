/*
 * @Author: Weidows
 * @Date: 2020-11-07 10:29:37
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 11:03:24
 * @FilePath: \SpringBoot\Spring-1\src\main\java\com\wei\service\UserServiceImpl.java
 * @Description:
 */
package com.wei.service;

import com.wei.dao.UserDao;

public class UserServiceImpl implements UserService {
  private UserDao userDao;

  @Override
  public void getUser() {
    userDao.getUser();
  }

  public void setUserDao(UserDao userDao) {
    this.userDao = userDao;
  }

}
