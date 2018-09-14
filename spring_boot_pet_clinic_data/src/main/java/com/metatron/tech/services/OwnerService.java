package com.metatron.tech.services;

import com.metatron.tech.model.Owner;



public interface OwnerService extends CrudService<Owner,Long>{

    Owner findByLastName(String lastName);



}
