package com.remamed.medical.controller;


import ch.qos.logback.core.net.SyslogOutputStream;
import com.remamed.medical.entity.Area;
import com.remamed.medical.service.AreaServcie;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@EnableCaching
public class AreaController {

    @Autowired
    private AreaServcie areaServcie;

    @RequestMapping("/findAreas")
    public List<Map<String,Object>> findAreas(){
        List<Area> areas=areaServcie.findAllAreas();
        return findAreasByPid(areas,-1);

    }

    private List<Map<String,Object>> findAreasByPid(List<Area> areas,Integer pid){
        List<Map<String,Object>> maps=new ArrayList<Map<String, Object>>();
        for (int i = 0; i < areas.size(); i++) {
            Area area=areas.get(i);
            Map<String, Object> map=null;
            if(area.getParentId().intValue()==pid.intValue()){
                map=new HashMap<>();
                map.put("value",area.getAreaId());
                map.put("label",area.getAreaName());
                map.put("children",findAreasByPid(areas,area.getAreaId()));
            }

            if(map!=null){
                maps.add(map);
            }
        }
        return maps;
    }


    private List<Map<String,Object>> remove(List<Map<String,Object>> list){
        List<Map<String,Object>> newMaps=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
             Map<String,Object> map=list.get(i);
             Map<String,Object> newMap=new HashMap<>();
             newMap.put("value",map.get("value"));
             newMap.put("label",map.get("label"));
             List<Map<String,Object>> children= (List<Map<String, Object>>) map.get("children");
             if(children!=null&&children.size()>0){
                 newMap.put("children",children);
                 remove(children);
             }
             newMaps.add(newMap);
        }

        return newMaps;
    }



}
