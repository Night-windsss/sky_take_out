package com.sky.service;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CategoryService {
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    void update(CategoryDTO categoryDTO);

    List<Category> getByType(Integer type);

    void startorstop(Integer status,Long id);

    void save(CategoryDTO categoryDTO);

    void deleteById(Long id);
}
