package com.wangxz.dao;

import com.wangxz.model.SysRolePrivilege;

public interface SysRolePrivilegeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysRolePrivilege record);

    int insertSelective(SysRolePrivilege record);

    SysRolePrivilege selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysRolePrivilege record);

    int updateByPrimaryKey(SysRolePrivilege record);
}