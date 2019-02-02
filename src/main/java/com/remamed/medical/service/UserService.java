package com.remamed.medical.service;

import com.remamed.medical.entity.UserEntity;

public interface UserService {

    void saveUser(UserEntity user);

    UserEntity findUserByNameOrTelephone(String name,String password);

    UserEntity findUserByLoginName(String loginName);

    UserEntity findUserByTelephone(String telephone);
}
