package com.liangxunwang.unimanager.query;

/**
 * Created by liuzwei on 2015/1/31.
 */
public class OrderQuery  extends BaseAreaQuery{
    private int index;
    private int size;
    private String is_jiaofei;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getIs_jiaofei() {
        return is_jiaofei;
    }

    public void setIs_jiaofei(String is_jiaofei) {
        this.is_jiaofei = is_jiaofei;
    }
}
