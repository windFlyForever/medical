package com.remamed.medical.mapper;

import com.remamed.medical.entity.Area;
import java.util.List;

public interface AreaMapper {

    int insert(Area record);

    Area selectByPrimaryKey(Integer areaId);

    List<Area> selectAll();

    int updateByPrimaryKey(Area record);

    List<Area> findAreasByParentId(Integer parentId);
}