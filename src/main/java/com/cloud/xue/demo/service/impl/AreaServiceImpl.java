package com.cloud.xue.demo.service.impl;

import com.cloud.xue.demo.config.DemoConfig;

import com.cloud.xue.demo.dao.AreaDao;
import com.cloud.xue.demo.entity.Area;
import com.cloud.xue.demo.enums.ResultEnum;
import com.cloud.xue.demo.exception.AreaException;
import com.cloud.xue.demo.service.AreaService;
import com.cloud.xue.demo.utils.TimeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    private final static Logger logger =LoggerFactory.getLogger(AreaServiceImpl.class);

    @Autowired
    public AreaDao areaDao;

    @Autowired
    public DemoConfig demoConfig;

    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    //该注解默认处理RuntimeException
    @Transactional
    public Area addArea(Area area) throws Exception{
        area.setCreateTime(TimeUtil.dateFormat("yyyyMMddHHmmss"));
        area.setLastEditTime(TimeUtil.dateFormat("yyyyMMddHHmmss"));
        try {
            int effectedNum = areaDao.insertArea(area);
            if (effectedNum > 0){
                return area;
            }else {
                throw new AreaException(ResultEnum.ADD_ERROR);
            }
        }catch (Exception e){
            throw new AreaException(ResultEnum.ADD_ERROR);
        }
    }

    @Override
    @Transactional
    public Area modifyArea(Area area) throws Exception{
        area.setLastEditTime(TimeUtil.dateFormat("yyyyMMddHHmmss"));
        try {
            int effectedNum = areaDao.updateArea(area);
            if(effectedNum > 0){
                return area;
            } else{
                throw new AreaException(ResultEnum.UPDATE_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new AreaException(ResultEnum.UPDATE_ERROR);
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int areaId) throws Exception{
        try{
            int effectedNum = areaDao.deleteArea(areaId);
            if (effectedNum > 0){
                logger.info("删除areaId={}成功",areaId);
                return true;
            }else {
                throw new AreaException(ResultEnum.DELETE_ERROR);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new AreaException(ResultEnum.DELETE_ERROR);
        }
    }
}
