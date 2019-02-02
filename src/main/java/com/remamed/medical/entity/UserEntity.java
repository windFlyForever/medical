package com.remamed.medical.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class UserEntity extends BaseEntity{
    private Integer mdUserId;

    private String realName;

    private String loginName;

    private String password;

    private String address;

    private String telephone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

}