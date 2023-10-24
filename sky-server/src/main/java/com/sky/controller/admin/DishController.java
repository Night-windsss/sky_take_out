package com.sky.controller.admin;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.DishService;
import com.sky.vo.DishVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/dish")
@Api(tags = "菜品相关接口")
@Slf4j
public class DishController {
    @Autowired
    private DishService dishservice;
    @PostMapping
    @ApiOperation("新增菜品")
    public Result save(@RequestBody DishDTO dishDto){
        log.info("菜品保存:{}",dishDto);
        dishservice.save(dishDto);
        return Result.success();
    }
    /*分页查询菜品*/
    @GetMapping("/page")
    @ApiOperation("菜品分页查询")
    public Result<PageResult> page(DishPageQueryDTO dishPageQueryDTO){
        PageResult pageResult = dishservice.pageQuery(dishPageQueryDTO);
        return Result.success(pageResult);
    }

    /*删除菜品*/
    @DeleteMapping
    @ApiOperation("删除菜品")
    public Result Delete(@RequestParam List<Long> ids){
        log.info("菜品删除：{}",ids);
        dishservice.deleteBatch(ids);
        return Result.success();
    }

     /*查询菜品*/
    @GetMapping("/{id}")
    @ApiOperation("查询菜品信息")
    public Result<DishVO> getById(@PathVariable Long id){
        log.info("查询菜品信息：{}",id);
        DishVO dishVO = dishservice.getByIdwithFlavor(id);
        return Result.success(dishVO);
    }

    @PutMapping
    @ApiOperation("更新菜品信息")
    /*修改菜品*/
    public Result update(@RequestBody DishDTO dishDTO){
        log.info("更新菜品信息：{}",dishDTO);
        dishservice.update(dishDTO);
        return Result.success();
    }

    @ApiOperation("启用禁用分类")
    @PostMapping("status/{status}")
    public Result startorstop(@PathVariable Integer status,Long id){
        log.info("分类启用或者禁用");
        dishservice.startorstop(status,id);
        return Result.success();
    }

    @ApiOperation("根据不同信息查询菜品信息")
    @GetMapping("/list")
    public Result<List<Dish>> list(Long categoryId){
        log.info("查询菜品信息：{}",categoryId);
        List<Dish> dishList = dishservice.list(categoryId);
        return Result.success(dishList);
    }
}
