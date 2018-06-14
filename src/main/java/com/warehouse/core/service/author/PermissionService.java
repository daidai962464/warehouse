package com.warehouse.core.service.author;

import com.warehouse.core.mapper.PermissionMapper;
import com.warehouse.core.po.Permission;
import com.warehouse.core.vo.SelectVo;
import com.warehouse.core.vo.TreeVo;
import com.warehouse.other.uitls.ConstantUtils;
import com.warehouse.other.uitls.WarehouseUtils;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/3 13:44
 */
@Service("permissionService")
public class PermissionService {

    @Autowired
    PermissionMapper permissionMapper;


    public List<Permission> getPermissionAll() {
        return permissionMapper.selectAll();
    }

    /**
     * 权限菜单管理查询
     *
     * @return
     */
    public List<TreeVo> getPermission() {
        List<TreeVo> treeVoList = new ArrayList<>();
        List<Permission> permissionList = permissionMapper.selectAll();
        for (Permission permission : permissionList) {
            if (permission.getLevel().equals(1L)) {
                getTreeVo(treeVoList, permission);
            }
        }
        WarehouseUtils.sort(treeVoList, "locationNumber", true);
        for (TreeVo treeVo : treeVoList) {
            List<TreeVo> treeVoChildList = new ArrayList<>();
            for (Permission permission : permissionList) {
                if (permission.getParentPermissionId() != null &&
                        permission.getParentPermissionId().equals(Long.valueOf(treeVo.getId()))) {
                    getTreeVo(treeVoChildList, permission);
                }
            }
            WarehouseUtils.sort(treeVoChildList, "locationNumber", true);
            treeVo.setChildren(treeVoChildList);
        }
        return treeVoList;
    }


    private void getTreeVo(List<TreeVo> treeVoList, Permission permission) {
        TreeVo treeVo = new TreeVo();
        treeVo.setId(permission.getPermissionId().toString());
        treeVo.setName(permission.getTitle());
        treeVo.setObject(permission);
        treeVo.setLocationNumber(permission.getLocationNumber());
        treeVoList.add(treeVo);
    }

    public boolean permissionAdd(Permission permission) {
        permissionMapper.insert(permission);
        return true;
    }

    public boolean permissionUpdate(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
        return true;
    }

    public boolean permissionDel(Long permissionId) {
        permissionMapper.deleteByPrimaryKey(permissionId);
        Example example = new Example(Permission.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("parentPermissionId", permissionId);
        permissionMapper.deleteByExample(example);
        return true;
    }


    public Permission getPermissionById(Long permissionId) {
        return permissionMapper.selectByPrimaryKey(permissionId);
    }

    public List<SelectVo> permissionLocationNumber(Long permissionId, Long parentPermissionId, Long level) {
        List<SelectVo> selectVoList = new ArrayList<>();
        if (permissionId != null) {
            Permission permission = permissionMapper.selectByPrimaryKey(permissionId);
            if (permission != null) {
                SelectVo selectVo = new SelectVo();
                selectVo.setValue(permission.getLocationNumber().toString());
                selectVo.setName(permission.getLocationNumber().toString());
                selectVo.setCheck("1");
                selectVoList.add(selectVo);
            }
        }
        List<Long> permissionLocationNumberBack = new ArrayList<Long>();
        permissionLocationNumberBack.add(1L);
        permissionLocationNumberBack.add(2L);
        permissionLocationNumberBack.add(3L);
        permissionLocationNumberBack.add(4L);
        permissionLocationNumberBack.add(5L);
        permissionLocationNumberBack.add(6L);
        permissionLocationNumberBack.add(7L);
        permissionLocationNumberBack.add(8L);
        permissionLocationNumberBack.add(9L);
        List<Long> longs = permissionMapper.permissionLocationNumber(parentPermissionId, level);
        permissionLocationNumberBack.removeAll(longs);
        Collections.sort(permissionLocationNumberBack);
        for (Long l : permissionLocationNumberBack) {
            SelectVo selectVo = new SelectVo();
            selectVo.setValue(l.toString());
            selectVo.setName(l.toString());
            selectVo.setCheck("0");
            selectVoList.add(selectVo);
        }
        return selectVoList;
    }

}
