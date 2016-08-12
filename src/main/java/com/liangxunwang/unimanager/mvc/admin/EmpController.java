package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.Emp;
import com.liangxunwang.unimanager.model.Role;
import com.liangxunwang.unimanager.query.EmpQuery;
import com.liangxunwang.unimanager.service.*;
import com.liangxunwang.unimanager.util.Constants;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.Page;
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
@RequestMapping("/emp")
public class EmpController extends ControllerConstants {
    @Autowired
    @Qualifier("empService")
    private ListService empServiceList;

    @Autowired
    @Qualifier("empService")
    private UpdateService empServiceUpdate;

    @Autowired
    @Qualifier("empService")
    private ExecuteService empServiceExecute;

    @RequestMapping("list")
    public String list(HttpSession session,ModelMap map, EmpQuery query, Page page){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        query.setIndex(page.getPage() == 0 ? 1 : page.getPage());
        query.setSize(query.getSize() == 0 ? page.getDefaultSize() : query.getSize());

        Object[] results = (Object[]) empServiceList.list(query);
        map.put("list", results[0]);
        long count = (Long) results[1];
        page.setCount(count);
        page.setPageCount(calculatePageCount(query.getSize(), count));
        map.addAttribute("page", page);
        map.addAttribute("query", query);

        //是否是顶级管理员 0是  1不是  用于页面是否展示操作功能
        if("0".equals(manager.getMm_manager_type()) || "4".equals(manager.getMm_manager_type())){
            map.put("is_manager", "0");
        }else {
            map.put("is_manager", "1");
        }

        //0经营户 1会员
        map.put("mm_emp_type", query.getMm_emp_type());

        return "/emp/list";
    }

    @RequestMapping("/detail")
    public String updateType(ModelMap map, HttpSession session, String mm_emp_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        //查看该会员信息
        Emp empVO = (Emp) empServiceExecute.execute(mm_emp_id);
        map.put("empVO", empVO);
        return "/emp/detail";
    }


    //更改会员数据
    @RequestMapping("/updateEmp")
    @ResponseBody
    public String updateEmp( HttpSession session, Emp emp){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        try {
            empServiceUpdate.update(emp);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }


    //管理员--添加管理员-搜索会员
    @RequestMapping("listAddManager")
    public String listAddManager(HttpSession session,ModelMap map, EmpQuery query, Page page){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        query.setIndex(page.getPage() == 0 ? 1 : page.getPage());
        query.setSize(query.getSize() == 0 ? page.getDefaultSize() : query.getSize());
        query.setMm_emp_type("0");//苗木经营户
        Object[] results = (Object[]) empServiceList.list(query);
        map.put("list", results[0]);
        long count = (Long) results[1];
        page.setCount(count);
        page.setPageCount(calculatePageCount(query.getSize(), count));
        map.addAttribute("page", page);
        map.addAttribute("query", query);

        return "/admin/add_list";
    }


    @Autowired
    @Qualifier("roleService")
    private ListService roleService;

    //管理员--添加管理员-搜索会员详情
    @RequestMapping("/listAddManager/detail")
    public String listAddManagerDetail(ModelMap map, HttpSession session, String mm_emp_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        Emp empVO = (Emp) empServiceExecute.execute(mm_emp_id);
        map.put("empVO", empVO);
        //角色
        List<Role> roles = (List<Role>) roleService.list("");
        map.put("roles", roles);
        return "/admin/add_detail";
    }

    @Autowired
    @Qualifier("empRegisterService")
    private SaveService empRegisterService;

    /**
     * 注册功能
     * @param member  会员对象
     * @return
     */
    @RequestMapping("/empReg")
    @ResponseBody
    public String empReg(Emp member){
        try {
            empRegisterService.save(member);
        }catch (ServiceException e){
            String msg = e.getMessage();
            if (msg.equals("MobileIsUse")){
                return toJSONString(ERROR_2);
            }
            if (msg.equals(Constants.SAVE_ERROR)){
                return toJSONString(ERROR_1);
            }

        }
        return toJSONString(SUCCESS);
    }

    @RequestMapping("/toReg")
    public String toReg(ModelMap map, HttpSession session, String mm_emp_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);

        return "/emp/addEmp";
    }


    @RequestMapping("/toUpdatePwr")
    public String toUpdatePwr(ModelMap map, HttpSession session, String mm_emp_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        Emp empVO = (Emp) empServiceExecute.execute(mm_emp_id);
        map.put("empVO", empVO);
        return "/emp/updatePwr";
    }


    //更改会员数据--密码
    @RequestMapping("/updateEmpPwr")
    @ResponseBody
    public String updateEmpPwr( HttpSession session, Emp emp){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        try {
            empServiceUpdate.update(emp);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

}
