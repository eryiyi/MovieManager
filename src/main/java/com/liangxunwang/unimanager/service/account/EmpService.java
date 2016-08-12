package com.liangxunwang.unimanager.service.account;

import com.liangxunwang.unimanager.dao.EmpDao;
import com.liangxunwang.unimanager.model.Emp;
import com.liangxunwang.unimanager.query.EmpQuery;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.Constants;
import com.liangxunwang.unimanager.util.MD5Util;
import com.liangxunwang.unimanager.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 */
@Service("empService")
public class EmpService implements ListService , UpdateService , ExecuteService{
    @Autowired
    @Qualifier("empDao")
    private EmpDao empDao;

    @Override
    public Object list(Object object) throws ServiceException {
        EmpQuery query = (EmpQuery) object;
        Map<String, Object> map = new HashMap<String, Object>();
        int index = (query.getIndex() - 1) * query.getSize();
        int size = query.getIndex() * query.getSize();

        map.put("index", index);
        map.put("size", size);


        if (!StringUtil.isNullOrEmpty(query.getMm_emp_type())) {
            map.put("mm_emp_type", query.getMm_emp_type());
        }

        if (!StringUtil.isNullOrEmpty(query.getIscheck())) {
            map.put("ischeck", query.getIscheck());
        }

        List<Emp> lists = empDao.listMemberByName(map);
        long count = empDao.count(map);


        return new Object[]{lists, count};
    }

    @Override
    public Object update(Object object) {
        if (object instanceof Emp){
            Emp emp = (Emp) object;
            if(emp != null && !StringUtil.isNullOrEmpty(emp.getMm_emp_password())){
                emp.setMm_emp_password(new MD5Util().getMD5ofStr(emp.getMm_emp_password()));//密码加密
                empDao.updatePwr(emp);
            }else {
                if(emp != null && !StringUtil.isNullOrEmpty(emp.getMm_emp_cover()) && !emp.getMm_emp_cover().startsWith("http://")){
                    empDao.updateCover(emp);
                }
                empDao.update(emp);
            }
        }
        return null;
    }

    @Override
    public Object execute(Object object) throws ServiceException {
        String id = (String) object;
        Emp empVO = empDao.findById(id);
        if (empVO !=null && !StringUtil.isNullOrEmpty(empVO.getMm_emp_cover())) {
            if (empVO.getMm_emp_cover().startsWith("upload")) {
                empVO.setMm_emp_cover(Constants.URL + empVO.getMm_emp_cover());
            }else {
                empVO.setMm_emp_cover(Constants.QINIU_URL + empVO.getMm_emp_cover());
            }
        }
        return empVO;
    }
}
