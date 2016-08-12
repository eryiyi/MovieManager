package com.liangxunwang.unimanager.mvc.vo;

import com.liangxunwang.unimanager.model.Record;

/**
 * Created by Administrator on 2016/2/14.
 */
public class RecordVO extends Record {
    private String mm_emp_mobile;
    private String mm_emp_nickname;
    private String mm_emp_type;
    private String mm_emp_cover;

    public String getMm_emp_mobile() {
        return mm_emp_mobile;
    }

    public void setMm_emp_mobile(String mm_emp_mobile) {
        this.mm_emp_mobile = mm_emp_mobile;
    }

    public String getMm_emp_nickname() {
        return mm_emp_nickname;
    }

    public void setMm_emp_nickname(String mm_emp_nickname) {
        this.mm_emp_nickname = mm_emp_nickname;
    }

    public String getMm_emp_type() {
        return mm_emp_type;
    }

    public void setMm_emp_type(String mm_emp_type) {
        this.mm_emp_type = mm_emp_type;
    }

    public String getMm_emp_cover() {
        return mm_emp_cover;
    }

    public void setMm_emp_cover(String mm_emp_cover) {
        this.mm_emp_cover = mm_emp_cover;
    }
}
