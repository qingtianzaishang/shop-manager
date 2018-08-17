package cn.edu.jxufe.service;

import cn.edu.jxufe.entity.Advertisement;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;

/**
 * Created by 74132 on 2018/8/8.
 */
public interface AdvertisementService {
    List<Advertisement> findAll();
    PageInfo<Advertisement> findAll(int page,int rows);
    Advertisement findAdvertisementById(int id);
    int  deleteAdvertisementById(int id);
    int  updateAdvertisementById(Advertisement advertisement);
    int  insertAdvertisement(Advertisement advertisement);
    PageInfo<Advertisement> findAdvertisementByProperty(String propertyeName,String propertyvalue,int page,int rows);

    PageInfo<Advertisement> findAdvertisementByTime(Date startTime,Date endTime,int page,int rows);
}
