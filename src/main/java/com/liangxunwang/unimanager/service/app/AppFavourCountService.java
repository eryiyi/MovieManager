package com.liangxunwang.unimanager.service.app;

import com.liangxunwang.unimanager.dao.FavourDao;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("appFavourCountService")
public class AppFavourCountService implements ExecuteService{

    @Autowired
    @Qualifier("favourDao")
    private FavourDao favourDao;

    @Override
    public Object execute(Object object) throws ServiceException {
        String mm_emp_id = (String) object;
        Map<String, Object> map = new HashMap<String, Object>();
        if (!StringUtil.isNullOrEmpty(mm_emp_id)) {
            map.put("mm_emp_id", mm_emp_id);
        }
        long count = favourDao.count(map);
        return String.valueOf(count);
    }

}
