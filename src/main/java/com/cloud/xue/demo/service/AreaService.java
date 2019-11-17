package com.cloud.xue.demo.service;

import com.cloud.xue.demo.entity.Area;

import java.util.List;

public interface AreaService {
    /**
     * 获取地区列表
     * @return
     */
    List<Area> getAreaList();

    /**
     * 根据地区ID查询地区
     * @param areaId
     * @return
     */
    Area getAreaById(int areaId);

    /**
     * 新增地区
     * @param area
     * @return
     */
    Area addArea(Area area) throws Exception;

    /**
     * 修改地区
     * @param area
     * @return
     */
    Area modifyArea(Area area) throws Exception;

    /**
     * 删除地区
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId) throws Exception;
}
