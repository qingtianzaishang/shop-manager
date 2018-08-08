package cn.edu.jxufe.service;

import cn.edu.jxufe.entity.Advertisement;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * Created by 74132 on 2018/8/8.
 */
public interface AdvertisementService {
    List<Advertisement> findAll();
    PageInfo<Advertisement> findAll(int page,int rows);
}
