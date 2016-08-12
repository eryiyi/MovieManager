package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.ReportObj;
import com.liangxunwang.unimanager.mvc.vo.ReportVO;
import com.liangxunwang.unimanager.query.ReportQuery;
import com.liangxunwang.unimanager.service.ExecuteService;
import com.liangxunwang.unimanager.service.ListService;
import com.liangxunwang.unimanager.service.ServiceException;
import com.liangxunwang.unimanager.service.UpdateService;
import com.liangxunwang.unimanager.util.ControllerConstants;
import com.liangxunwang.unimanager.util.Page;
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
@RequestMapping("/report")
public class ReportController extends ControllerConstants {
    @Autowired
    @Qualifier("reportService")
    private ListService reportService;

    @Autowired
    @Qualifier("reportService")
    private ExecuteService reportServiceExecute;


    @Autowired
    @Qualifier("reportService")
    private UpdateService reportServiceUpdate;

    @RequestMapping("list")
    public String listQiugou(HttpSession session,ModelMap map, ReportQuery query, Page page){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        query.setIndex(page.getPage() == 0 ? 1 : page.getPage());
        query.setSize(query.getSize() == 0 ? page.getDefaultSize() : query.getSize());
        Object[] results = (Object[]) reportService.list(query);
        map.put("list", results[0]);
        long count = (Long) results[1];
        page.setCount(count);
        page.setPageCount(calculatePageCount(query.getSize(), count));
        map.addAttribute("page", page);
        map.addAttribute("query", query);
        return "report/list";
    }


    @RequestMapping("detail")
    public String add(ModelMap map, String id){
        ReportVO reportVO = (ReportVO) reportServiceExecute.execute(id);
        map.put("reportVO", reportVO);
        return "/report/detail";
    }

    //更改数据
    @RequestMapping("/update")
    @ResponseBody
    public String updateEmp( HttpSession session, String mm_report_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        try {
            ReportObj reportObj = new ReportObj();
            reportObj.setMm_manager_id(manager.getMm_manager_id());
            reportObj.setMm_report_id(mm_report_id);
            reportServiceUpdate.update(reportObj);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

}
