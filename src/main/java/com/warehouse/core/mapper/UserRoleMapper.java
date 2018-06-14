package com.warehouse.core.mapper;

import com.warehouse.core.po.UserRole;

public interface UserRoleMapper {
    int insert(UserRole record);

    int insertSelective(UserRole record);
}