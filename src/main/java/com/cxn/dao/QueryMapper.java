package com.cxn.dao;

import com.cxn.model.Order;

/**
 * @program: mybatis
 * @description: ${高级查询}
 * @author: cxn
 * @create: 2018-04-19 20:55
 * @Version v1.0
 */

public interface QueryMapper {
    /**
     * 根据订单号查询出订单信息和用户信息
     * @param orderNum
     * @return
     */
    Order queryOrderAndUserByOrderNumber(String orderNum);

    /**
     * 根据订单编号查询出订单，用户，订单详情信息
     * @param orderNum
     * @return
     */
    Order queryOrderWithUserAndOrderDetailsByOrderNumber(String orderNum);

    /**
     * 根据订单编号查询订单，及订单所属用户和订单下的详情信息和对应商品信息
     * @param orderNumber
     * @return
     */
    Order queryOrderUserOrderDetailItemByOrderNumber(String orderNumber);

    /**
     * 测试懒加载
     * @param orderNumber
     * @return
     */
    Order lazyQueryOrderWithUserByOrderNumber(String orderNumber);
}
