package com.liangxunwang.unimanager.mvc.app;

import com.liangxunwang.unimanager.model.Emp;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.util.Constants;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by liuzwei on 2015/1/29.
 */
@Controller
public class MemberRegisterController extends ControllerConstants {

    /**
     */

    @Autowired
    @Qualifier("memberRegisterService")
    private SaveService memberRegisterService;


    /**
     * 注册功能
     * @param member  会员对象
     * @return
     */
    @RequestMapping("/memberRegister")
    @ResponseBody
    public String register(Emp member){
        try {
            memberRegisterService.save(member);
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



}
