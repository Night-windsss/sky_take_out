package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.GoodsSalesDTO;
import com.sky.dto.OrdersPageQueryDTO;
import com.sky.entity.Orders;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Mapper
public interface OrderMapper {
    void insert(Orders orders);

    Page<Orders> pageQuery(OrdersPageQueryDTO ordersPageQueryDTO);
    @Select("select * from orders where id = #{id}")
    Orders getById(Long id);

    void update(Orders orders);
    @Select("select count(id) from orders where status = #{status}")
    Integer countStatus(Integer toBeConfirmed);
    @Select("select * from orders where number = #{orderNumber}")
    Orders getByNumber(String orderNumber);

    @Select("select * from orders where status = #{status} and order_time < #{ordertime}")
    List<Orders> getByStatusAndOrderTimeLT(Integer status, LocalDateTime ordertime);
    @Select("select sum(amount) from orders where order_time between #{begin} and #{end} and status = #{status}")
    Double sumByMap(Map<String, Object> map);


    Integer countByMap(Map<String, Object> map);


    List<GoodsSalesDTO> getSalesTop10(LocalDateTime begin, LocalDateTime end);
}
