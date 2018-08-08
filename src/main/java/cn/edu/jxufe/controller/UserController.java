package cn.edu.jxufe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 74132 on 2018/8/3.
 */
@Controller
public class UserController {
    @RequestMapping("user")
    @ResponseBody
    public Object getUser(){
        System.out.println("有一个请求来了！");
        Map map=new HashMap();
        map.put("uid","wuwenjie");
        map.put("pwd",123456);
        return map;
    }
    @RequestMapping("finduser")
    @ResponseBody
    public Object getUser(Integer uid){
        System.out.println("有一个请求来了，请求传入一个参数"+uid);
        System.out.println("调用业务功能实现通过uid查询用户信息");
        Map map=new HashMap();
        map.put("uid",uid);
        map.put("name","刘大狗");
        map.put("pwd",123456);
        return map;
    }


    @RequestMapping("f{uid}user")
    @ResponseBody
    public Object findUser(@PathVariable("uid") Integer uid){
        System.out.println("有一个请求来了，请求传入一个参数"+uid);
        System.out.println("调用业务功能实现通过uid查询用户信息");
        Map map=new HashMap();
        map.put("uid",uid);
        map.put("name","刘大狗");
        map.put("pwd",123456);
        return map;
    }

    @RequestMapping("login")
    @ResponseBody
    public Object getLogin(String telAccount,String pwd){
        System.out.println("处理一个登录请求");
        System.out.println("来一个手机账号："+telAccount);
        System.out.println("传入手机账号密码1："+pwd);
        if(telAccount.equals("13423712915") && pwd.equals("123456")){
            return "登录成功！";
        }else
        {
            return "登录失败";
        }


    }

    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @RequestMapping("404")
    public String page404(){
        System.out.println("通过控制器处理一个jsp请求");
        return "404";
    }
}
