package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.AdDao;
import com.liangxunwang.unimanager.model.AdObj;
import com.liangxunwang.unimanager.query.AdQuery;
import com.liangxunwang.unimanager.service.*;
import com.liangxunwang.unimanager.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liuzwei on 2015/3/3.
 */
@Service("adObjService")
public class AdObjService implements ListService,SaveService ,DeleteService,ExecuteService, UpdateService{
    @Autowired
    @Qualifier("adDao")
    private AdDao leveldDao;

    @Override
    public Object list(Object object) throws ServiceException {
        AdQuery query = (AdQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        List<AdObj> lists = leveldDao.lists(map);
        return lists;
    }

    @Override
    public Object save(Object object) throws ServiceException {
        AdObj adObj = (AdObj) object;
        adObj.setMm_ad_id(UUIDFactory.random());
        adObj.setMm_ad_type("0");
        leveldDao.save(adObj);
        return null;
    }

    @Override
    public Object delete(Object object) throws ServiceException {
        String mm_ad_id = (String) object;
        leveldDao.delete(mm_ad_id);
        return null;
    }

    @Override
    public Object execute(Object object) throws ServiceException {
        return leveldDao.findById((String) object);
    }

    @Override
    public Object update(Object object) {
        AdObj adObj = (AdObj) object;
        leveldDao.update(adObj);
        return null;
    }
}
