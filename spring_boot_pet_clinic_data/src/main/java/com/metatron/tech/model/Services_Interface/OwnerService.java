package com.metatron.tech.model.Services_Interface;

import com.metatron.tech.model.entities.Owner;


public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);



}
