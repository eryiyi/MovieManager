package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.OrderDao;
import com.liangxunwang.unimanager.mvc.vo.OrderVO;
import com.liangxunwang.unimanager.query.OrderQuery;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("orderService")
public class OrderService implements ListService {
    @Autowired
    @Qualifier("orderDao")
    private OrderDao orderDao;

    @Override
    public Object list(Object object) throws ServiceException {
        OrderQuery query = (OrderQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        int index = (query.getIndex() - 1) * query.getSize();
        int size = query.getIndex() * query.getSize();

        map.put("index", index);
        map.put("size", size);

        if (!StringUtil.isNullOrEmpty(query.getIs_jiaofei())) {
            map.put("is_jiaofei", query.getIs_jiaofei());
        }

        List<OrderVO> lists = orderDao.lists(map);
        long count = orderDao.count(map);

        return new Object[]{lists, count};
    }



}
