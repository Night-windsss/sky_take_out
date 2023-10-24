package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    List<Long> getsetmealIdBydishIds(List<Long> dishIds);

    void insert(List<SetmealDish> setmealDishes);
    @Delete("delete from setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBysetmealId(Long setmealId);
    @Select("select * from setmeal_dish where setmeal_id = #{id}")
    List<SetmealDish> getBySetmealId(Long id);

}
