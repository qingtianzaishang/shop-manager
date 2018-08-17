package cn.edu.jxufe.service.iml;

import cn.edu.jxufe.dao.AdvertisementDAO;
import cn.edu.jxufe.entity.Advertisement;
import cn.edu.jxufe.service.AdvertisementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by 74132 on 2018/8/8.
 */
@Service
public class AdvertisementServiceImpl implements AdvertisementService {

@Autowired
private AdvertisementDAO advertisementDAO;
    @Override
    public List<Advertisement> findAll() {
        return advertisementDAO.findAllAdvertisement();
    }

    @Override
    public PageInfo<Advertisement> findAll(int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Advertisement> data=findAll();
        PageInfo<Advertisement> pageInfo =new PageInfo<Advertisement>(data);
        System.out.println("总行数==>"+pageInfo.getTotal());
        System.out.println("总页数==>"+pageInfo.getPages());
        System.out.println("数据内容==>"+pageInfo.getList());
        return pageInfo;
    }

    @Override
    public Advertisement findAdvertisementById(int id) {
        return advertisementDAO.selectByPrimaryKey(id);
    }

    @Override
    public int deleteAdvertisementById(int id) {
        return advertisementDAO.deleteByPrimaryKey(id);
    }

    @Override
    public int updateAdvertisementById(Advertisement advertisement) {
        return advertisementDAO.updateByPrimaryKey(advertisement);
    }

    @Override
    public int insertAdvertisement(Advertisement advertisement) {
        return advertisementDAO.insert(advertisement);
    }


    @Override
    public PageInfo<Advertisement> findAdvertisementByProperty(String propertyeName, String propertyvalue, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Advertisement>data=advertisementDAO.findAdvertisementByProperty(propertyeName,propertyvalue);
        PageInfo<Advertisement> pageInfo=new PageInfo<Advertisement>(data);
        System.out.println("总行数==>"+pageInfo.getTotal());
        System.out.println("总页数==>"+pageInfo.getPages());
        System.out.println("数据内容==>"+pageInfo.getList());
        return pageInfo;
    }

    @Override
    public PageInfo<Advertisement> findAdvertisementByTime(Date startTime, Date endTime, int page, int rows) {
        PageHelper.startPage(page,rows);
        List<Advertisement> data=advertisementDAO.findAdvertisementByTime(startTime, endTime);
        PageInfo<Advertisement>pageInfo=new PageInfo<Advertisement>(data);
        System.out.println("总行数==>"+pageInfo.getTotal());
        System.out.println("总页数==>"+pageInfo.getPages());
        System.out.println("数据内容==>"+pageInfo.getList());
        return pageInfo;
    }


}
