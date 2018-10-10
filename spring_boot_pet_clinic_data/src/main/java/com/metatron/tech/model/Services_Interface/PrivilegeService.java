package com.metatron.tech.model.Services_Interface;

import com.metatron.tech.model.entities.Privilege;

public interface PrivilegeService extends CrudService<Privilege, Long> {

    Privilege findByName(String name);
}
