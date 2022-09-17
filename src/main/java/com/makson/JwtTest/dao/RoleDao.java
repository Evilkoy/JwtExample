package com.makson.JwtTest.dao;

import com.makson.JwtTest.model.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleDao extends CrudRepository<Role,Long> {
    Role findByName(String name);
}
