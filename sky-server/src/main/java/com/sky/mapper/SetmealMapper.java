package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);
    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);
    @Select("select * from setmeal where  id = #{id}")
    Setmeal getById(Long id);
    @Delete("delete from setmeal where id = #{setmealId}")
    void deleteById(Long setmealId);

    void update(Setmeal setmeal);
    //动态查询
    List<Setmeal> list(Setmeal setmeal);
    @Select("select sd.copies,sd.name,d.image,d.description  " +
            "from setmeal_dish sd left join dish d on sd.dish_id = d.id " +
            "where setmeal_id = #{id}")
    List<DishItemVO> getDishItemByCatoryId(Long id);
}
