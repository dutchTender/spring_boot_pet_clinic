package com.metatron.tech.model.services;

import com.metatron.tech.model.Spring_Security.model.Role;

public interface RoleService extends  CrudService<Role, Long> {

    public Role findByRole(String role);
}
