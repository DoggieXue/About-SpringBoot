package com.cloud.xue.demo.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Area {
    //主键ID
    //@NotNull(message="区域ID不能为空")
    @Id
    @GeneratedValue
    private Integer areaId;
    //名称
    @NotBlank(message="地区名称不能为空")
    private  String areaName;
    //权重，越大越排前显示
    @Min(value=1, message="权重值不能小于1")
    @Max(value=10,message="权重值不能大于10")
    private Integer priority;
    //创建时间
    private String createTime;
    //更新时间
    private String lastEditTime;
    //
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getLastEditTime() {
        return lastEditTime;
    }

    public void setLastEditTime(String lastEditTime) {
        this.lastEditTime = lastEditTime;
    }

    @Override
    public String toString() {
        return "\"Area\":{" +
                "areaId:" + areaId +
                ", areaName:'" + areaName + '\'' +
                ", priority:" + priority +
                ", createTime:'" + createTime + '\'' +
                ", lastEditTime:'" + lastEditTime + '\'' +
                '}';
    }
}
