package cn.edu.jxufe.controller;


import cn.edu.jxufe.entity.Advertisement;
import cn.edu.jxufe.service.AdvertisementService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

    @RequestMapping("advertisementdatabypro")
    @ResponseBody
    public Object advertisementdatabypro(String pn,String pv,@RequestParam(name="page",defaultValue = "1") int page,@RequestParam(name="rows",defaultValue = "10")int rows){
        try {
            PageInfo<Advertisement> data= advertisementService.findAdvertisementByProperty(pn,pv,page,rows);
            Map map=new HashMap();
            map.put("total",data.getTotal());
            map.put("rows",data.getList());
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return "{errmsg:"+e.getMessage()+"}";
        }
    }

    @RequestMapping("advertisementdatabytime")
    @ResponseBody
    public Object advertisementdatabytime(Date startTime,Date endTime,@RequestParam(name="page",defaultValue = "1") int page,@RequestParam(name="rows",defaultValue = "10")int rows){
        try {
            PageInfo<Advertisement> data= advertisementService.findAdvertisementByTime(startTime,endTime,page,rows);
            Map map=new HashMap();
            map.put("total",data.getTotal());
            map.put("rows",data.getList());
            return map;
        }catch (Exception e){
            e.printStackTrace();
            return "{errmsg:"+e.getMessage()+"}";
        }
    }


    @RequestMapping("advertisementbyid")
    public String toAdvertisementbyid(int id,ModelMap map){
        System.out.println("广告编辑页面的");
        Advertisement adv=advertisementService.findAdvertisementById(id);
        map.put("adv",adv);
        return "guanggao_edit";
    }
@RequestMapping("deleteadvertisementbyid")
@ResponseBody
public Object todeleteadvertisementbyid(int id){
    System.out.println("删除广告");
    return advertisementService.deleteAdvertisementById(id);
}

    @RequestMapping("updateadvertisementbyid")
    @ResponseBody
    public Object toupdateadvertisementbyid(Advertisement advertisement){
        return advertisementService.updateAdvertisementById(advertisement);
    }

    @RequestMapping("insertadvertisement")
    @ResponseBody
    public Object toinsertadvertisement(Advertisement advertisement){
        return advertisementService.insertAdvertisement(advertisement);
    }



    @RequestMapping("uploadAdImage")
    @ResponseBody
    public Object uploadAdImage(@RequestParam ("fs")MultipartFile f,HttpServletRequest req){
        System.out.println("准备文件上传");
      System.out.println("输出上传的这个文件的文件名"+f.getOriginalFilename());
      String path=req.getSession().getServletContext().getRealPath("/upload/");
      System.out.println("站点的实际路径："+path);
      String fileName= UUID.randomUUID().toString()+f.getOriginalFilename();
try {
    FileOutputStream fou = new FileOutputStream(path + fileName);
    fou.write(f.getBytes());
    fou.close();
    return fileName;

}catch (Exception ex){
    ex.printStackTrace();
    return null;
}

  }

    @RequestMapping("savead")
    @ResponseBody
    public Object savead(@RequestParam ("title") String title,@RequestParam("link")String link,@RequestParam("url")String url){
        System.out.println("准备存储到数据库");
        System.out.println("title-->"+title);
        System.out.println("link-->"+link);
        System.out.println("url-->"+url);
        return "success";
    }


}
