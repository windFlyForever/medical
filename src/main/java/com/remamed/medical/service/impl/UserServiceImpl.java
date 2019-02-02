package com.remamed.medical.service.impl;

import com.remamed.medical.entity.UserEntity;
import com.remamed.medical.mapper.UserEntityMapper;
import com.remamed.medical.service.UserService;
import com.remamed.medical.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityMapper userMapper;

    @Override
    @Transactional
    public void saveUser(UserEntity user) {
        if(user.getPassword()!=null&&user.getPassword()!=""){
            user.setPassword(Md5Util.getStrMD5(user.getPassword()));
        }

        userMapper.insert(user);
    }

    @Override
    @Cacheable(value="login")
    public UserEntity findUserByNameOrTelephone(String name,String password) {
       UserEntity user= userMapper.selectByLoginNameOrTelephone(name,Md5Util.getStrMD5(password));
       return user;
    }

    @Override
    @Cacheable(value="findLoginName")
    public UserEntity findUserByLoginName(String loginName) {
        UserEntity user= userMapper.findUserByLoginName(loginName);
        return user;
    }

    @Override
    @Cacheable(value="findTelephone")
    public UserEntity findUserByTelephone(String telephone) {

        UserEntity user= userMapper.findUserByTelephone(telephone);
        return user;
    }


}
