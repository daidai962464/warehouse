package com.warehouse.core.mapper;

import com.warehouse.config.BaseMapper;
import com.warehouse.core.po.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper extends BaseMapper<Permission> {

    @Select("<script> " +
            "   SELECT DISTINCT a.location_number from permission a where 1=1 " +
            "  <if test='level != null'> and a.`level`= #{level} </if>" +
            "  <if test='parentPermissionId != null'> and a.parent_permission_id = #{parentPermissionId} </if>" +
            "  <if test='parentPermissionId == null'> and a.parent_permission_id is NULL </if>" +
            "</script>")
    public List<Long> permissionLocationNumber(@Param("parentPermissionId") Long parentPermissionId,@Param("level") Long level);
}