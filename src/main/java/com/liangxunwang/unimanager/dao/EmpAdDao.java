package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.EmpAdObj;
import com.liangxunwang.unimanager.mvc.vo.EmpAdVO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("empAdDao")
public interface EmpAdDao {

    /**
     * 查询会员广告图
     */
    List<EmpAdVO> lists(Map<String, Object> map);

    //保存
    void save(EmpAdObj empAdVO);

    //删除
    void delete(String mm_emp_ad_id);

}
