package com.cloud.xue.demo.dao;

import com.cloud.xue.demo.entity.Area;
import com.cloud.xue.demo.utils.TimeUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {

    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(5, areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area = areaDao.queryAreaById(2);
        assertEquals("北苑", area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setPriority(2);
        area.setLastEditTime(TimeUtil.dateFormat("yyyyMMddHHmmss"));
        int changeNum = areaDao.insertArea(area);
        assertEquals(1,changeNum);
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        area.setAreaId(1);
        area.setAreaName("南苑");
        area.setLastEditTime(TimeUtil.dateFormat("yyyyMMddHHmmss"));
        int changeNum = areaDao.updateArea(area);
        assertEquals(1,changeNum);
    }

    @Test
    @Ignore
    public void deleteArea() {
        int changeNum = areaDao.deleteArea(3);
        assertEquals(1,changeNum);
    }
}