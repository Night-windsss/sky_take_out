package com.sky.controller.admin;


import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin/category")
@Slf4j
public class CategoryController {
    @Autowired
    CategoryService categoryService;


    /*分页查询*/
    @GetMapping("/page")
    @ApiOperation("分页查询")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("分页查询");
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


    /*修改分类*/
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }


    /*根据类型查询分类*/
    @GetMapping("/list")
    @ApiOperation("根据类型查询分类")
    public Result<Category> getByType(Integer type){
        Category category = categoryService.getByType(type);
        return Result.success(category);
    }

    /*启用禁用分类*/
    @ApiOperation("启用禁用分类")
    @PostMapping("status/{status}")
    public Result startorstop(@PathVariable Integer status,Long id){
        log.info("分类启用或者禁用");
        categoryService.startorstop(status,id);
        return Result.success();
    }

    /*添加分类*/
    @PostMapping
    @ApiOperation("添加分类")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("添加分类");
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /*根据id删除分类*/
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result deleteById(Long id){
        log.info("删除分类");
        categoryService.deleteById(id);
        return  Result.success();
    }
}
