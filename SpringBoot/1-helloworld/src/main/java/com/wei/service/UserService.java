/*
 * @Author: Weidows
 * @Date: 2020-11-07 09:31:08
 * @LastEditors: Weidows
 * @LastEditTime: 2020-11-07 11:11:27
 * @FilePath: \SpringBoot\Spring-1\src\main\java\com\wei\service\UserService.java
 * @Description:
 */
package com.wei.service;

import com.wei.dao.UserDao;

public interface UserService {
  void getUser();

  void setUserDao(UserDao userDao);
}
