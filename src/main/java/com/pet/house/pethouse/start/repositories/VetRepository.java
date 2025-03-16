package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VetRepository extends JpaRepository<Vets,Long> {

    Optional<Vets> findBySpecializationName(String speciality);

    Optional<Vets> findByEmail(String email);

//    @Query("SELECT v FROM Vets v WHERE v.speciality.name LIKE  :prefix%")
//    Optional<Vets> findBySpeciality(@Param("prefix") String prefix);
}
