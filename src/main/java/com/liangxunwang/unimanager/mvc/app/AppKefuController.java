package com.liangxunwang.unimanager.mvc.app;

import com.liangxunwang.unimanager.model.KefuTel;
import com.liangxunwang.unimanager.model.tip.DataTip;
import com.liangxunwang.unimanager.query.KefuQuery;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liuzwei on 2015/2/2.
 */
@Controller
public class AppKefuController extends ControllerConstants {

    @Autowired
    @Qualifier("kefuTelService")
    private ListService kefuTelService;

    //列表
    @RequestMapping(value = "/getKefuTel", produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String getKefuTel(KefuQuery query){
        try {
            List<KefuTel> list = (List<KefuTel>) kefuTelService.list(query);
            DataTip tip = new DataTip();
            tip.setData(list);
            return toJSONString(tip);
        }catch (ServiceException e){
            String msg = e.getMessage();
            if (msg.equals("accessTokenNull")){
                return toJSONString(ERROR_9);
            }else{
                return toJSONString(ERROR_1);
            }
        }
    }

}
