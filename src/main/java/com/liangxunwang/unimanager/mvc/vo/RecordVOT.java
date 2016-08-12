package com.liangxunwang.unimanager.mvc.vo;

import com.liangxunwang.unimanager.model.RecordT;

/**
 * Created by Administrator on 2016/2/14.
 */
public class RecordVOT extends RecordT {
    private String mm_emp_mobile;
    private String mm_emp_nickname;
    private String mm_emp_type;
    private String mm_emp_cover;
    private String mm_emp_company_type;
    private String mm_emp_company;
    private String mm_level_id;
    private String is_chengxin;
    private String is_miaomu;
    private String mm_level_num;
    private String area;//县区名称
    private String cityName;//城市名字

    private String lat;//发布信息的人所处的位置
    private String lng;//

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMm_level_num() {
        return mm_level_num;
    }

    public void setMm_level_num(String mm_level_num) {
        this.mm_level_num = mm_level_num;
    }

    public String getMm_emp_cover() {
        return mm_emp_cover;
    }

    public void setMm_emp_cover(String mm_emp_cover) {
        this.mm_emp_cover = mm_emp_cover;
    }

    public String getIs_chengxin() {
        return is_chengxin;
    }

    public void setIs_chengxin(String is_chengxin) {
        this.is_chengxin = is_chengxin;
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

    public String getMm_emp_company_type() {
        return mm_emp_company_type;
    }

    public void setMm_emp_company_type(String mm_emp_company_type) {
        this.mm_emp_company_type = mm_emp_company_type;
    }

    public String getMm_emp_company() {
        return mm_emp_company;
    }

    public void setMm_emp_company(String mm_emp_company) {
        this.mm_emp_company = mm_emp_company;
    }

    public String getMm_level_id() {
        return mm_level_id;
    }

    public void setMm_level_id(String mm_level_id) {
        this.mm_level_id = mm_level_id;
    }



    public String getIs_miaomu() {
        return is_miaomu;
    }

    public void setIs_miaomu(String is_miaomu) {
        this.is_miaomu = is_miaomu;
    }
}
