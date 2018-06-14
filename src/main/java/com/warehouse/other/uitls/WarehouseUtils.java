package com.warehouse.other.uitls;

import com.github.pagehelper.PageInfo;
import com.warehouse.core.po.User;
import com.warehouse.core.vo.PageVo;
import org.apache.commons.beanutils.BeanComparator;
import org.apache.commons.collections.ComparatorUtils;
import org.apache.commons.collections.comparators.ComparableComparator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/11 15:04
 */
public class WarehouseUtils {

    public static <T> void sort(List<T> list, String fieldName, boolean asc) {
        Comparator<?> mycmp = ComparableComparator.getInstance();
        // 允许null
        mycmp = ComparatorUtils.nullLowComparator(mycmp);
        if (!asc) {
            // 逆序
            mycmp = ComparatorUtils.reversedComparator(mycmp);
        }
        Collections.sort(list, new BeanComparator(fieldName, mycmp));
    }


    public static PageVo getPageVo(PageInfo<?> pageInfo){
        PageVo pageVo =new PageVo();
        pageVo.setCode(0);
        pageVo.setMsg("");
        pageVo.setCount(pageInfo.getTotal());
        pageVo.setData(pageInfo.getList());
        return pageVo;
    }

}
