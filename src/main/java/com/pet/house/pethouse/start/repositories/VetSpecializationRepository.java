package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.VetMastersIn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VetSpecializationRepository extends JpaRepository<VetMastersIn,Long> {
//    Optional<VetMastersIn>findByVetSpeciality(String VetSpecialisation);
}
