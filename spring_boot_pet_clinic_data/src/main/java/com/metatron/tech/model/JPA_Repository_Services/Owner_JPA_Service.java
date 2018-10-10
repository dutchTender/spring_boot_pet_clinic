package com.metatron.tech.model.JPA_Repository_Services;

import com.metatron.tech.model.JPA_Repositories.OwnerRepository;
import com.metatron.tech.model.JPA_Repositories.PetRepository;
import com.metatron.tech.model.JPA_Repositories.PetTypeRepository;
import com.metatron.tech.model.entities.Owner;
import com.metatron.tech.model.Services_Interface.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
@Profile("JPA")
public class Owner_JPA_Service implements OwnerService {

    ////////////////////////////////////////////////////////////////////////////
    // DI for spring JPA
    ////////////////////////////////////////////////////////////////////////////
    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public Owner_JPA_Service(OwnerRepository ownerRepository, PetRepository petRepository, PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }
    ///////////////////////////////////////////////////////////////////////////


    @Override
    public Owner findByLastName(String lastName) {
        return  ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owner -> owners.add(owner));
        System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");

        return owners;
    }

    @Override
    public Optional<Owner> findById(Long id) {
        return  ownerRepository.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {

        ownerRepository.delete(object);

    }

    @Override
    public void deleteById(Long id) {

        ownerRepository.deleteById(id);

    }

    public OwnerRepository getOwnerRepository() {
        return this.ownerRepository;
    }

    public PetRepository getPetRepository() {
        return this.petRepository;
    }

    public PetTypeRepository getPetTypeRepository() {
        return this.petTypeRepository;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Owner_JPA_Service)) return false;
        final Owner_JPA_Service other = (Owner_JPA_Service) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$ownerRepository = this.getOwnerRepository();
        final Object other$ownerRepository = other.getOwnerRepository();
        if (this$ownerRepository == null ? other$ownerRepository != null : !this$ownerRepository.equals(other$ownerRepository))
            return false;
        final Object this$petRepository = this.getPetRepository();
        final Object other$petRepository = other.getPetRepository();
        if (this$petRepository == null ? other$petRepository != null : !this$petRepository.equals(other$petRepository))
            return false;
        final Object this$petTypeRepository = this.getPetTypeRepository();
        final Object other$petTypeRepository = other.getPetTypeRepository();
        if (this$petTypeRepository == null ? other$petTypeRepository != null : !this$petTypeRepository.equals(other$petTypeRepository))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $ownerRepository = this.getOwnerRepository();
        result = result * PRIME + ($ownerRepository == null ? 43 : $ownerRepository.hashCode());
        final Object $petRepository = this.getPetRepository();
        result = result * PRIME + ($petRepository == null ? 43 : $petRepository.hashCode());
        final Object $petTypeRepository = this.getPetTypeRepository();
        result = result * PRIME + ($petTypeRepository == null ? 43 : $petTypeRepository.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Owner_JPA_Service;
    }

    public String toString() {
        return "Owner_JPA_Service(ownerRepository=" + this.getOwnerRepository() + ", petRepository=" + this.getPetRepository() + ", petTypeRepository=" + this.getPetTypeRepository() + ")";
    }
}
