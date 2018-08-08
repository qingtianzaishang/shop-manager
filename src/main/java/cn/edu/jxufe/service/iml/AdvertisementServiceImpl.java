package cn.edu.jxufe.service.iml;

import cn.edu.jxufe.dao.AdvertisementDAO;
import cn.edu.jxufe.entity.Advertisement;
import cn.edu.jxufe.service.AdvertisementService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
