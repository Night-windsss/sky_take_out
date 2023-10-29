package com.sky.service;

import com.sky.dto.*;
import com.sky.result.PageResult;
import com.sky.vo.OrderPaymentVO;
import com.sky.vo.OrderStatisticsVO;
import com.sky.vo.OrderVO;

public interface OrderService {
    PageResult pageQuery4User(OrdersPageQueryDTO ordersPageQueryDTO);

    OrderVO details(Long id);

    void cancel(Long id);

    void repetition(Long id);

    PageResult conditionSearch(OrdersPageQueryDTO ordersPageQueryDTO);

    OrderStatisticsVO statistics();

    void confirm(OrdersConfirmDTO ordersConfirmDTO);

    void rejection(OrdersRejectionDTO ordersRejectionDTO);

    void cancel(OrdersCancelDTO ordersCancelDTO) throws Exception;;

    void delivery(Long id);

    void complete(Long id);

    OrderPaymentVO payment(OrdersPaymentDTO ordersPaymentDTO);
}
