package com.remamed.medical.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserTypeEntity extends BaseEntity{
    private Integer userTypeId;

    private String typeCode;

    private String typeName;

}