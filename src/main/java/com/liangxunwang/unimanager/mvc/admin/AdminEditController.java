package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.Role;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
public class AdminEditController extends ControllerConstants {

    @Autowired
    @Qualifier("adminEditService")
    private ExecuteService adminEditService;

    @Autowired
    @Qualifier("adminEditService")
    private UpdateService adminUpdateService;


    @RequestMapping("/admin/detail")
    public String toUpdateType(HttpSession session,ModelMap map, String id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        Object[] results = (Object[]) adminEditService.execute(id);
        Admin admin = (Admin) results[0];
        String permissions = (String) results[1];
        Role role  = (Role) results[2];

        map.put("admin", admin);
        if(role != null){
            map.put("role", role);
        }else {
            map.put("roleRname", "最高管理员");
        }
        map.put("permissions_admin", permissions);
        return "/admin/detail";
    }

    @RequestMapping("/admin/updateType")
    @ResponseBody
    public String updateType(HttpSession session, String mm_manager_id, String mm_manager_is_use){
        try {
            Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
            Object[] params = new Object[]{mm_manager_id, mm_manager_is_use};
            adminUpdateService.update(params);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

}
