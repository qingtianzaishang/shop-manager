package cn.edu.jxufe.dao;

import cn.edu.jxufe.entity.Goodsinfo;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * GoodsinfoDAO继承基类
 */
@Repository
public interface GoodsinfoDAO extends MyBatisBaseDao<Goodsinfo, Integer> {
    List<Goodsinfo> findAllGoodsinfo();
    public List<Goodsinfo> findGoodsInfoByProperty(@Param("propertyName") String propertyName,@Param("propertyValue") Object propertyValue);
    public List<Goodsinfo> findGoodsInfoByTime(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}