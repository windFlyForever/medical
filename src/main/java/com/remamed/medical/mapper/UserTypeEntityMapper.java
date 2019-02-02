package com.remamed.medical.mapper;

import com.remamed.medical.entity.UserTypeEntity;
import java.util.List;

public interface UserTypeEntityMapper {

    int insert(UserTypeEntity record);

    UserTypeEntity selectByPrimaryKey(Integer userTypeId);

    List<UserTypeEntity> selectAll();

    int updateByPrimaryKey(UserTypeEntity record);
}