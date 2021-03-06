package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.AboutUsDao;
import com.liangxunwang.unimanager.model.AboutUs;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("aboutUsService")
public class AboutUsService implements ListService,SaveService ,UpdateService{
    @Autowired
    @Qualifier("aboutUsDao")
    private AboutUsDao aboutUsDao;

    @Override
    public Object list(Object object) throws ServiceException {
        Map<String, Object> map = new HashMap<String, Object>();
        List<AboutUs> lists = aboutUsDao.lists(map);
        return lists;
    }


    @Override
    public Object save(Object object) throws ServiceException {
        AboutUs aboutUs = (AboutUs) object;
        aboutUs.setMm_about_id(UUIDFactory.random());
        aboutUsDao.save(aboutUs);
        return null;
    }


    @Override
    public Object update(Object object) {
        AboutUs feiyongObj = (AboutUs) object;
        aboutUsDao.update(feiyongObj);
        return null;
    }
}
