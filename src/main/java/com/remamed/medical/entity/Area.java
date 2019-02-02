package com.remamed.medical.entity;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Area extends BaseEntity{
    private Integer areaId;

    private String areaCode;

    private String areaName;

    private Byte level;

    private String cityCode;

    private String center;

    private Integer parentId;

    private List<Area> children;
}