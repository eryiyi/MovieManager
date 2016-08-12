package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.RecordT;
import com.liangxunwang.unimanager.mvc.vo.RecordVOT;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("recordTDao")
public interface RecordTDao {

    /**
     * 查询求购、供应信息
     */
    List<RecordVOT> listRecordVo(Map<String, Object> map);
    //竞价排名
    List<RecordVOT> listRecordVoTop(Map<String, Object> map);

    long count(Map<String, Object> map);

    /**
     * 保存一条信息
     * @param record
     */
    void save(RecordT record);

    /**
     * 根据ID查找动态
     * @return
     */
    RecordVOT findById(String id);

    //删除动态
   void deleteById(String mm_msg_id);

    //更新置顶状态
    void updateTop(RecordT record);


    //查询用户今天发布的信息数量
    long countbyEmpId(Map<String, Object> map);
}
