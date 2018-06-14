package com.warehouse.core.service.user;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.warehouse.core.mapper.UserMapper;
import com.warehouse.core.po.User;
import com.warehouse.other.uitls.ConstantUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

/**
 * @author wangding
 * @version V1.0
 * @date 2017/12/31 15:49
 */
@Service("userService")
public class UserService {

    @Autowired
    UserMapper userMapper;

    public User selectByMobile(String mobile) {
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("mobile", mobile);
        List<User> userList = userMapper.selectByExample(example);
        if (CollectionUtils.isNotEmpty(userList)) {
            return userList.get(0);
        }
        return null;
    }



    public PageInfo<User> getUserList(int page, int limit, String jobNumber, String mobile, String email, Long status, String isDel) {
        PageHelper.startPage(page, limit);
        Example example = new Example(User.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(jobNumber)){
            criteria.andEqualTo("jobNumber",jobNumber);
        }
        if(StringUtils.isNotEmpty(mobile)){
            criteria.andEqualTo("mobile",mobile);
        }
        if(StringUtils.isNotEmpty(email)){
            criteria.andEqualTo("email",email);
        }
        if(status!=null){
            criteria.andEqualTo("status",status);
        }
        if(StringUtils.isNotEmpty(isDel)){
            criteria.andEqualTo("isDel",isDel);
        }
        example.orderBy("addTime").desc();
        List<User> userList = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    }


    public boolean addUser(User user){
        user.setAddTime(new Date());
        user.setIsDel(ConstantUtils.DEL_FALSE);
        user.setUserType("1");



    return true;
    }

}
