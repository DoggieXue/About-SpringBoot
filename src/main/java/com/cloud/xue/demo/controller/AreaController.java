package com.cloud.xue.demo.controller;

import com.cloud.xue.demo.entity.Result;
import com.cloud.xue.demo.enums.ResultEnum;
import com.cloud.xue.demo.exception.AreaException;
import com.cloud.xue.demo.service.AreaService;
import com.cloud.xue.demo.entity.Area;
import com.cloud.xue.demo.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea", method = RequestMethod.POST)
    public Result<Area> listArea(){
        return  ResultUtil.success(areaService.getAreaList(), ResultEnum.SUCCESS);
    }

    @GetMapping(value = "/areas/{id}")
    public Result<Area> getAreaById(@PathVariable("id") Integer areaId){
        return  ResultUtil.success(areaService.getAreaById(areaId), ResultEnum.SUCCESS);
    }

    @RequestMapping(value = "/addarea", method = RequestMethod.POST)
    public Result<Area> addArea(@Valid Area area, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()){
            return ResultUtil.error("1", bindingResult.getFieldError().getDefaultMessage());
        }
        try{
            //int a = 1/0;//模拟未知错误
            return ResultUtil.success(areaService.addArea(area), ResultEnum.SUCCESS);
        }catch (AreaException e){
            return ResultUtil.error(ResultEnum.ADD_ERROR);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }

    /**
     * 修改地区信息
     * @param area
     * @param bindingResult
     * @return
     * @throws Exception
     */
    @PostMapping(value="/update")
    public Result<Area> modifyArea(@Valid Area area, BindingResult bindingResult) throws Exception{
        if (bindingResult.hasErrors()){
            return ResultUtil.error("1", bindingResult.getFieldError().getDefaultMessage());
        }

        try {
            return ResultUtil.success(areaService.modifyArea(area), ResultEnum.SUCCESS);
        }catch (AreaException e){
            return ResultUtil.error(ResultEnum.UPDATE_ERROR);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }

    @PostMapping(value = "/areas/{id}")
    public Result<Area> deleteArea(@PathVariable("id") Integer areaId) throws Exception{
        try {
            return ResultUtil.success(areaService.deleteArea(areaId), ResultEnum.SUCCESS);
        }catch (AreaException e){
            return ResultUtil.error(ResultEnum.DELETE_ERROR);
        }catch (Exception e){
            return ResultUtil.error(ResultEnum.UNKNOW_ERROR);
        }
    }
}
