package com.weidows.dao.role;


import com.weidows.pojo.Role;

import java.sql.Connection;
import java.util.List;

public interface RoleDao {

    /**
     * 获取角色列表
     *
     * @param connection
     * @return
     * @throws Exception
     */
    List<Role> getRoleList(Connection connection) throws Exception;

}
