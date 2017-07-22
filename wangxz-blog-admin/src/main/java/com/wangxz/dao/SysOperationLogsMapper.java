package com.wangxz.dao;

import com.wangxz.model.SysOperationLogs;

public interface SysOperationLogsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysOperationLogs record);

    int insertSelective(SysOperationLogs record);

    SysOperationLogs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysOperationLogs record);

    int updateByPrimaryKey(SysOperationLogs record);
}