package com.liangxunwang.unimanager.mvc.app;

import com.liangxunwang.unimanager.model.AccessToken;
import com.liangxunwang.unimanager.model.Emp;
import com.liangxunwang.unimanager.model.tip.DataTip;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.SaveService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.StringUtil;
import com.liangxunwang.unimanager.util.UUIDFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberLoginController extends ControllerConstants {
    /**
     */
    @Autowired
    @Qualifier("memberLoginService")
    private ExecuteService memberLoginService;

    @Autowired
    @Qualifier("appAccessTokenService")
    private ExecuteService appAccessTokenServiceExe;

    @Autowired
    @Qualifier("appAccessTokenService")
    private SaveService appAccessTokenServiceSave;
    @Autowired
    @Qualifier("appAccessTokenService")
    private UpdateService appAccessTokenServiceUpdate;
    /**
     * 会员登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    @RequestMapping(value = "/memberLogin" ,produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String memberLogin(@RequestParam String username, @RequestParam String password){
        if (StringUtil.isNullOrEmpty(username)){
            return toJSONString(ERROR_5);
        }
        if (StringUtil.isNullOrEmpty(password)){
            return toJSONString(ERROR_6);
        }
        Object[] params = new Object[]{username, password};
        Emp member = null;
        try {
            member = (Emp) memberLoginService.execute(params);
            //先查询是否登陆过 -有无seesion记录
            AccessToken accessToken = (AccessToken) appAccessTokenServiceExe.execute(member.getMm_emp_id());//根据用户iD查询是否存在用户登陆记录
            if(accessToken != null){
                //说明登陆过，有记录
                accessToken.setAccess_token(UUIDFactory.random());//随机生成一个新的 accseeToken
                appAccessTokenServiceUpdate.update(accessToken);
            }else {
                //说明没有登录记录
                accessToken = new AccessToken();
                accessToken.setMm_access_token_id(UUIDFactory.random());
                accessToken.setMm_emp_id(member.getMm_emp_id());
                accessToken.setAccess_token(UUIDFactory.random());//随机生成一个 accseeToken
                appAccessTokenServiceSave.save(accessToken);
            }
            //获得accesstoken
            member.setAccess_token(accessToken.getAccess_token());
        }catch (ServiceException e){
            String emsg = e.getMessage();
            if (emsg.equals("NotFound")){
                return toJSONString(ERROR_1);
            }
            if (emsg.equals("PassError")){
                return toJSONString(ERROR_2);
            }
            if (emsg.equals("NotUse")){
                return toJSONString(ERROR_3);
            }
            if (emsg.equals("NotCheck")){
                return toJSONString(ERROR_4);
            }
        }
        DataTip tip = new DataTip();
        tip.setData(member);
        return toJSONString(tip);
    }
}
