package com.liangxunwang.unimanager.mvc.vo;

import com.liangxunwang.unimanager.model.OrderObj;

/**
 * Created by Administrator on 2016/2/14.
 */
public class OrderVO extends OrderObj{
    private String mm_emp_nickname;

    public String getMm_emp_nickname() {
        return mm_emp_nickname;
    }

    public void setMm_emp_nickname(String mm_emp_nickname) {
        this.mm_emp_nickname = mm_emp_nickname;
    }
}
