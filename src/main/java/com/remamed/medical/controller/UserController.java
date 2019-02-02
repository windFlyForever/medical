package com.remamed.medical.controller;


import com.remamed.medical.dict.CommonDict;
import com.remamed.medical.entity.UserEntity;
import com.remamed.medical.service.UserService;
import com.remamed.medical.util.RespResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableCaching
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * @Description 用户注册信息的请求方法
     * @Date 2019-01-31
     * @Param [user]
     * @return com.remamed.medical.util.RespResult
     **/
    @RequestMapping(value = "/registerUser")
    public RespResult registerUser(UserEntity user){
        RespResult result=null;
        try {
            UserEntity u=userService.findUserByTelephone(user.getTelephone());
            if(u!=null){

                return new RespResult(CommonDict.RESP_FAILED_CODE,"该手机号已注册！");
            }
            user.setVld(CommonDict.NORMAL);
            userService.saveUser(user);
            return new RespResult(CommonDict.RESP_SUCCESS_CODE,"注册成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new RespResult(CommonDict.RESP_EXCEPTION_CODE,"注册失败，请联系管理员！");
        }

    }
    
    /***
     * @Description 用户登录验证
     * @Date 2019-01-31
     * @Param [name, password, req]
     * @return com.remamed.medical.util.RespResult
     **/
    @RequestMapping("/login")
    public RespResult login(String name, String password, HttpServletRequest req){

        RespResult result=null;
        UserEntity user=userService.findUserByNameOrTelephone(name,password);
        if(user!=null){
            result=new RespResult(CommonDict.RESP_SUCCESS_CODE,"登录成功！");
            req.getSession().setAttribute(CommonDict.USER_IN_SESSION,user);
        }else{
            result=new RespResult("","账号或者密码有误！");
        }
        return result;
    }
    
    /**
     * @Description 查找注册用户名是否已存在
     * @Date 2019-01-31
     * @Param [loginName]
     * @return com.remamed.medical.util.RespResult
     **/
    @RequestMapping("/findLoginName")
    public RespResult findUserByLoginName(String loginName){

        RespResult result=new RespResult("");
        UserEntity user=userService.findUserByLoginName(loginName);
        if(user!=null){
            result=new RespResult(CommonDict.RESP_SUCCESS_CODE,"该用户名已存在！");
        }
        return result;
    }

    /**
     * @Description 查找注册手机号是否已存在
     * @Date 2019-01-31
     * @Param [telephone]
     * @return com.remamed.medical.util.RespResult
     **/
    @RequestMapping("/findTelephone")
    public RespResult findUserByTelephone(String telephone){

        RespResult result=new RespResult("");
        UserEntity user=userService.findUserByTelephone(telephone);
        if(user!=null){
            result=new RespResult(CommonDict.RESP_SUCCESS_CODE,"该手机号已注册！");
        }
        return result;
    }

}
