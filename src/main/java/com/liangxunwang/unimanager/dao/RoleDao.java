package com.liangxunwang.unimanager.dao;

import com.liangxunwang.unimanager.model.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("roleDao")
public interface RoleDao {
    List<Role> list();

    void save(Role role);

    void delete(String id);

    Role find(String id);

    void update(Role role);
}
