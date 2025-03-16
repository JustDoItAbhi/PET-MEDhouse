package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRespository extends JpaRepository<Pets,Long> {
    @Query("SELECT p FROM Pets p WHERE p.owner.id = :id")
    Optional<Pets> findByOwnerId(@Param("id") long id);

}
