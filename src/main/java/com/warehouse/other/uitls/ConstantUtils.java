package com.warehouse.other.uitls;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2018/1/5 10:39
 */
public class ConstantUtils {

    public static final String SUCCESS = "success";


    /**
     * 权限级别
     */
    public static final Long PERMISSION_LEVEL_1 = 1L;
    public static final Long PERMISSION_LEVEL_2 = 2L;

    public static final String SPREAD_OFF = "off";
    public static final String SPREAD_ON = "on";
    public static final Long LEVEL_1 = 1L;
    public static final Long LEVEL_2 = 2L;


    public static final String DEL_TRUE = "1";
    public static final String DEL_FALSE= "0";


    /**
     * 权限菜单位置编号 暂定10个
     */
    public static final List<Long> PERMISSION_LOCATION_NUMBER = new ArrayList<Long>();

    static {
        PERMISSION_LOCATION_NUMBER.add(1L);
        PERMISSION_LOCATION_NUMBER.add(2L);
        PERMISSION_LOCATION_NUMBER.add(3L);
        PERMISSION_LOCATION_NUMBER.add(4L);
        PERMISSION_LOCATION_NUMBER.add(5L);
        PERMISSION_LOCATION_NUMBER.add(6L);
        PERMISSION_LOCATION_NUMBER.add(7L);
        PERMISSION_LOCATION_NUMBER.add(8L);
        PERMISSION_LOCATION_NUMBER.add(9L);
    }

}
