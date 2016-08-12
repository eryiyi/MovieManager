package com.liangxunwang.unimanager.mvc.app;

import com.liangxunwang.unimanager.model.Emp;
import com.liangxunwang.unimanager.model.tip.DataTip;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
public class AppEmpController extends ControllerConstants {

    @Autowired
    @Qualifier("empService")
    private ExecuteService empServiceExecute;


    @RequestMapping(value = "/getMemberInfoById", produces = "text/plain;charset=UTF-8;")
    @ResponseBody
    public String getMemberInfoById(String id){
        try {
            //查看该会员信息
            Emp empVO = (Emp) empServiceExecute.execute(id);
            DataTip tip = new DataTip();
            tip.setData(empVO);
            return toJSONString(tip);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

    @Autowired
    @Qualifier("appEmpService")
    private UpdateService appEmpService;

    @RequestMapping(value = "/sendLocation", produces = "text/plain;charset=UTF-8;")
    @ResponseBody
    public String sendLocation(String mm_emp_id,String lat, String lng){
        try {
            //保存用户定位数据
            Emp emp = new Emp();
            emp.setMm_emp_id(mm_emp_id);
            appEmpService.update(emp);
            DataTip tip = new DataTip();
            tip.setData(tip);
            return toJSONString(tip);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

    @RequestMapping(value = "/updatePwr", produces = "text/plain;charset=UTF-8;")
    @ResponseBody
    public String updatePwr(String mm_emp_mobile,String newpass){
        try {
            //修改用户密码
            Emp emp = new Emp();
            emp.setMm_emp_mobile(mm_emp_mobile);
            emp.setMm_emp_password(newpass);
            appEmpService.update(emp);
            DataTip tip = new DataTip();
            tip.setData(tip);
            return toJSONString(tip);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

    @Autowired
    @Qualifier("appEmpService")
    private ListService appEmpServiceList;


    @RequestMapping(value = "/getNearby", produces = "text/plain;charset=UTF-8;")
    @ResponseBody
    public String getNearby(String lat, String lng){
        try {
            List<Emp> lists = (List<Emp>)appEmpServiceList.list("");
            DataTip tip = new DataTip();
            tip.setData(lists);
            return toJSONString(tip);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

}
