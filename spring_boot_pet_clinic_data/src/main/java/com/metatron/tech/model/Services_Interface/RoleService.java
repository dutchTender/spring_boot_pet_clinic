package com.metatron.tech.model.Services_Interface;

import com.metatron.tech.model.entities.Role;

public interface RoleService extends  CrudService<Role, Long> {

    public Role findByRole(String role);
}
