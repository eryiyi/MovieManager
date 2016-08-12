package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.AboutUs;
import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
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
import java.util.List;

/**
 * Created by liuzh on 2015/8/12.
 */
@Controller
@RequestMapping("/aboutUs")
public class AboutUsController extends ControllerConstants {

    @Autowired
    @Qualifier("aboutUsService")
    private ListService feiyongServiceList;

    @Autowired
    @Qualifier("aboutUsService")
    private SaveService feiyongServiceSave;

    @Autowired
    @Qualifier("aboutUsService")
    private UpdateService feiyongServiceUpdate;



    @RequestMapping("add")
    public String add(ModelMap map){
        List<AboutUs> list = (List<AboutUs>) feiyongServiceList.list("");
       if(list != null && list.size() > 0){
           map.put("aboutUs", list.get(0));
       }
        return "/about/addAboutUs";
    }

    @RequestMapping("addAboutUs")
    @ResponseBody
    public String addAboutUs(HttpSession session,AboutUs aboutUs){
        List<AboutUs> list = (List<AboutUs>) feiyongServiceList.list("");
        if(list != null && list.size() > 0){
            //需要跟新
            Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
            try {
                feiyongServiceUpdate.update(aboutUs);
                return toJSONString(SUCCESS);
            }catch (ServiceException e){
                return toJSONString(ERROR_1);
            }
        }else {
            Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
            feiyongServiceSave.save(aboutUs);
            return toJSONString(SUCCESS);
        }
    }


}
