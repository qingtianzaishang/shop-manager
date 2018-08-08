package cn.edu.jxufe.controller;


import cn.edu.jxufe.entity.Advertisement;
import cn.edu.jxufe.service.AdvertisementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 74132 on 2018/8/8.
 */
@Controller
public class AdvertisementController {
@Autowired
    private AdvertisementService advertisementService;
    @RequestMapping("advertisement")
    public String toAdvertisement(){
        System.out.println("广告管理界面的");
        return "guanggao";
    }

    @RequestMapping("advertisementdata")
    @ResponseBody
    public Object advertisementdata(@RequestParam(name = "page",defaultValue = "1")int page,@RequestParam(name="rows",defaultValue = "10")int rows){
        System.out.println("传递过来的page==>"+page);
        System.out.println("传递过来的rows==>"+rows);
        try{
            PageInfo<Advertisement>data=advertisementService.findAll(page, rows);
            Map map=new HashMap();
            map.put("total",data.getTotal());
            map.put("rows",data.getList());
        return map;
        }catch (Exception ex){
            ex.printStackTrace();
            return "{errmsg:"+ex.getMessage()+"}";
        }
    }
}
