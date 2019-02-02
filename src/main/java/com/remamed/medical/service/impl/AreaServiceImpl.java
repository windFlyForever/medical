package com.remamed.medical.service.impl;

import com.remamed.medical.entity.Area;
import com.remamed.medical.mapper.AreaMapper;
import com.remamed.medical.service.AreaServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AreaServiceImpl implements AreaServcie {

    @Autowired
    private AreaMapper areaMapper;


    @Override
    public List<Area> findAllAreas() {
        return areaMapper.selectAll();
    }
}
