package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.EmpAdObj;
import com.liangxunwang.unimanager.mvc.vo.EmpAdVO;
import com.liangxunwang.unimanager.query.EmpAdQuery;
import com.liangxunwang.unimanager.service.DeleteService;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/empAd")
public class EmpAdController extends ControllerConstants {

    @Autowired
    @Qualifier("empAdService")
    private ListService levelService;

    @Autowired
    @Qualifier("empAdService")
    private SaveService levelServiceSave;

    @Autowired
    @Qualifier("empAdService")
    private ExecuteService levelServiceSaveExe;

    @Autowired
    @Qualifier("empAdService")
    private DeleteService levelServiceSaveDel;

    @RequestMapping("list")
    public String list(HttpSession session,ModelMap map, EmpAdQuery query){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        List<EmpAdVO> list = (List<EmpAdVO>) levelService.list(query);
        map.put("list", list);
        map.put("mm_emp_id", query.getMm_emp_id());
        return "/empAd/list";
    }

    @RequestMapping("toAdd")
    public String add(ModelMap map, EmpAdQuery query){
        map.put("mm_emp_id",query.getMm_emp_id());
        return "/empAd/addEmpAd";
    }

    @RequestMapping("addEmpAd")
    @ResponseBody
    public String addEmpAd(HttpSession session,EmpAdObj empAdObj){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        levelServiceSave.save(empAdObj);
        return toJSONString(SUCCESS);
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(HttpSession session,String mm_emp_ad_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        levelServiceSaveDel.delete(mm_emp_ad_id);
        return toJSONString(SUCCESS);
    }


}
