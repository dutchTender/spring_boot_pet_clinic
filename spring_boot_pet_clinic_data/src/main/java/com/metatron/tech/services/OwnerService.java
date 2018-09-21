package com.metatron.tech.services;

import com.metatron.tech.model.Owner;
import org.springframework.stereotype.Component;


@Component
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);



}
