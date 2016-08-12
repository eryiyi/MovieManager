package com.liangxunwang.unimanager.mvc.vo;

import com.liangxunwang.unimanager.model.Favour;

/**
 * Created by Administrator on 2016/2/14.
 */
public class FavourVO extends Favour {
    private String mm_msg_type;
    private String mm_msg_title;
    private String mm_msg_content;
    private String mm_msg_picurl;
    private String mm_msg_videourl;
    private String mm_emp_mobile;
    private String mm_emp_nickname;
    private String mm_emp_type;
    private String mm_emp_cover;
    private String datelineRecord;

    public String getMm_msg_videourl() {
        return mm_msg_videourl;
    }

    public void setMm_msg_videourl(String mm_msg_videourl) {
        this.mm_msg_videourl = mm_msg_videourl;
    }

    public String getMm_msg_type() {
        return mm_msg_type;
    }

    public void setMm_msg_type(String mm_msg_type) {
        this.mm_msg_type = mm_msg_type;
    }

    public String getMm_msg_title() {
        return mm_msg_title;
    }

    public void setMm_msg_title(String mm_msg_title) {
        this.mm_msg_title = mm_msg_title;
    }

    public String getMm_msg_content() {
        return mm_msg_content;
    }

    public void setMm_msg_content(String mm_msg_content) {
        this.mm_msg_content = mm_msg_content;
    }

    public String getMm_msg_picurl() {
        return mm_msg_picurl;
    }

    public void setMm_msg_picurl(String mm_msg_picurl) {
        this.mm_msg_picurl = mm_msg_picurl;
    }

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

    public String getDatelineRecord() {
        return datelineRecord;
    }

    public void setDatelineRecord(String datelineRecord) {
        this.datelineRecord = datelineRecord;
    }
}
