package com.remamed.medical.mapper;

import com.remamed.medical.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserEntityMapper {

    int insert(UserEntity record);

    UserEntity selectByPrimaryKey(Integer mdUserId);

    List<UserEntity> selectAll();

    int updateByPrimaryKey(UserEntity record);

    UserEntity selectByLoginNameOrTelephone(@Param("name") String name, @Param("password") String password);

    UserEntity findUserByLoginName(String loginName);

    UserEntity findUserByTelephone(String telephone);
}