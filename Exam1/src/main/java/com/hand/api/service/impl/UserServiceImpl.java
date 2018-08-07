package com.hand.api.service.impl;

import javax.annotation.Resource;

import com.hand.api.service.UserService;
import com.hand.domain.entity.UserE;
import com.hand.infra.dataobject.UserDO;
import com.hand.infra.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public void createUser(UserE userE) {
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userE, userDO);
        userMapper.insert(userDO);
        userE.setId(userDO.getId());
    }

    @Override
    public UserE getUserById(Long id) {
        UserDO userDO = userMapper.selectByPrimaryKey(id);
        UserE userE = new UserE();
        BeanUtils.copyProperties(userDO, userE);
        return userE;
    }

    @Override
    public UserDO findUserId(Long id) {
        return userMapper.selectById(id);
    }
}
