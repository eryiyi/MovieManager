package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.mvc.vo.OrderVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("orderDao")
public interface OrderDao {

    /**
     * 查询订单
     */
    List<OrderVO> lists(Map<String, Object> map);
    long count(Map<String, Object> map);


}
