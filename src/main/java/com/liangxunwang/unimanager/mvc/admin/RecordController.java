package com.liangxunwang.unimanager.mvc.admin;

import com.liangxunwang.unimanager.model.Admin;
import com.liangxunwang.unimanager.model.Record;
import com.liangxunwang.unimanager.mvc.vo.RecordVO;
import com.liangxunwang.unimanager.query.RecordQuery;
import com.liangxunwang.unimanager.service.*;
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
@RequestMapping("/record")
public class RecordController extends ControllerConstants {
    @Autowired
    @Qualifier("recordService")
    private ListService recordService;

    @Autowired
    @Qualifier("recordService")
    private DeleteService recordServiceDele;

    @Autowired
    @Qualifier("recordService")
    private ExecuteService recordServiceExer;

    @Autowired
    @Qualifier("recordService")
    private UpdateService recordServiceUpdate;

    @RequestMapping("listQiugou")
    public String listQiugou(HttpSession session,ModelMap map, RecordQuery query, Page page){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        query.setIndex(page.getPage() == 0 ? 1 : page.getPage());
        query.setSize(query.getSize() == 0 ? page.getDefaultSize() : query.getSize());
        query.setMm_msg_type("0");


        Object[] results = (Object[]) recordService.list(query);
        map.put("list", results[0]);
        long count = (Long) results[1];
        page.setCount(count);
        page.setPageCount(calculatePageCount(query.getSize(), count));
        map.addAttribute("page", page);
        map.addAttribute("query", query);
        map.addAttribute("mm_msg_type", "0");

        return "record/list";
    }
    @RequestMapping("listGongying")
    public String listGongying(HttpSession session,ModelMap map, RecordQuery query, Page page){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        query.setIndex(page.getPage() == 0 ? 1 : page.getPage());
        query.setSize(query.getSize() == 0 ? page.getDefaultSize() : query.getSize());
        query.setMm_msg_type("1");

        Object[] results = (Object[]) recordService.list(query);
        map.put("list", results[0]);
        long count = (Long) results[1];
        page.setCount(count);
        page.setPageCount(calculatePageCount(query.getSize(), count));
        map.addAttribute("page", page);
        map.addAttribute("query", query);
        map.addAttribute("mm_msg_type", "1");
        return "record/list";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(HttpSession session,String mm_msg_id){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        recordServiceDele.delete(mm_msg_id);
        return toJSONString(SUCCESS);
    }


    @RequestMapping("toDetail")
    public String add(ModelMap map, String mm_msg_id){
        RecordVO recordVO = (RecordVO) recordServiceExer.execute(mm_msg_id);
        map.put("recordVO", recordVO);
        return "/record/detail";
    }

    //更改数据
    @RequestMapping("/update")
    @ResponseBody
    public String updateEmp( HttpSession session, Record record){
        Admin manager = (Admin) session.getAttribute(ACCOUNT_KEY);
        try {
            recordServiceUpdate.update(record);
            return toJSONString(SUCCESS);
        }catch (ServiceException e){
            return toJSONString(ERROR_1);
        }
    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "/record/addRecord";
    }
}
