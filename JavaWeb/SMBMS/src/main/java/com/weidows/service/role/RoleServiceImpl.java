package com.weidows.service.role;


import com.weidows.dao.BaseDao;
import com.weidows.dao.role.RoleDao;
import com.weidows.dao.role.RoleDaoImpl;
import com.weidows.pojo.Role;

import java.sql.Connection;
import java.util.List;

public class RoleServiceImpl implements RoleService {

  private Connection connection = null;
  private RoleDao roleDao = null;

  public RoleServiceImpl() {
    roleDao = new RoleDaoImpl();
  }

  /**
   * 获取角色列表
   *
   * @return
   */
  @Override
  public List<Role> getRoleList() {
    List<Role> roleList = null;
    try {
      connection = BaseDao.getConnection();
      roleList = roleDao.getRoleList(connection);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      BaseDao.closeResource(connection, null, null);
    }
    return roleList;
  }
}
