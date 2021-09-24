package com.weidows.dao.role;


import com.weidows.dao.BaseDao;
import com.weidows.pojo.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoleDaoImpl implements RoleDao {

  /**
   * 获取角色列表
   *
   * @param connection
   * @return
   * @throws Exception
   */
  @Override
  public List<Role> getRoleList(Connection connection) throws Exception {
    List<Role> roleList = new ArrayList<>();
    ResultSet resultSet = null;
    if (connection != null) {
      String sql = "select * from smbms_role";
      Object[] params = {};
      resultSet = BaseDao.execute(connection, null, sql, params);
      while (resultSet.next()) {
        Role _role = new Role();
        _role.setId(resultSet.getInt("id"));
        _role.setRoleCode(resultSet.getString("roleCode"));
        _role.setRoleName(resultSet.getString("roleName"));
        roleList.add(_role);
      }
      BaseDao.closeResource(null, BaseDao.preparedStatement, resultSet);
    }
    return roleList;
  }

}
