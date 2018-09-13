package com.metatron.tech.services;

import com.metatron.tech.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    Set<Vet> findall();
}
