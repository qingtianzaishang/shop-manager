package cn.edu.jxufe.dao;

import cn.edu.jxufe.entity.Advertisement;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * AdvertisementDAO继承基类
 */
@Repository
public interface AdvertisementDAO extends MyBatisBaseDao<Advertisement, Integer> {
 List<Advertisement> findAllAdvertisement();

 public List<Advertisement> findAdvertisementByProperty(@Param("propertyName") String propertyName,@Param("propertyValue") Object propertyValue);

 public List<Advertisement> findAdvertisementByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}