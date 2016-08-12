package com.liangxunwang.unimanager.mvc;

import com.liangxunwang.unimanager.util.ControllerConstants;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 *
 */
public class ControllerInterceptor extends ControllerConstants implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String uri = request.getRequestURI();
        Object account = request.getSession().getAttribute(ACCOUNT_KEY);

        if(uri.contains(".json")){
                return true;
        }

        if(uri.matches("(^/$)|(^/index\\.do$)|(^/adminLogin\\.do$)|(^/logout\\.do$)" +
                        "|(^/uploadImage\\.do$)" +
                        "|(^/uploadUnCompressImage\\.do$)" +
                        "|(^/getMemberInfoById\\.do$)"+
                        "|(^/memberRegister\\.do$)"+
                        "|(^/recordList\\.do$)"+
                        "|(^/sendRecord\\.do$)"+
                        "|(^/getRecordById\\.do$)"+
                        "|(^/viewRecord\\.do$)"+
                        "|(^/recordListById\\.do$)"+
                        "|(^/sendLocation\\.do$)"+
                        "|(^/getFuwuByLocationAndType\\.do$)"+
                        "|(^/getAboutUs\\.do$)"+
                        "|(^/suggest/addSuggest\\.do$)"+
                        "|(^/updatePwr\\.do$)"+
                        "|(^/getEmpAd\\.do$)"+
                        "|(^/getNearby\\.do$)"+
                        "|(^/getTopMsg\\.do$)"+
                        "|(^/getVipList\\.do$)"+
                        "|(^/getLevelById\\.do$)"+
                        "|(^/saveReport\\.do$)"+
                        "|(^/saveFavour\\.do$)"+
                        "|(^/getFavourById\\.do$)"+
                        "|(^/getKefuTel\\.do$)"+
                        "|(^/getFavourCount\\.do$)"+
                        "|(^/deleteFavour\\.do$)"+
                        "|(^/getLoginAd\\.do$)"+

                        "|(^/recordListT\\.do$)"+
                        "|(^/recordListByIdT\\.do$)"+
                        "|(^/sendRecordT\\.do$)"+
                        "|(^/getRecordByIdT\\.do$)"+

                        "|(^/memberLogin\\.do$)"
        ) || account != null) {
            return true;
        }

        if("true".equals(request.getParameter("j"))) {
            PrintWriter out = response.getWriter();
            out.print(toJSONString(TIMEOUT));
            out.close();
        } else {
            request.getRequestDispatcher("/WEB-INF/session.jsp").forward(request, response);
        }
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
