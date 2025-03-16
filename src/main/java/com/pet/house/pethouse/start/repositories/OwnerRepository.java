package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner,Long> {
    Optional<Owner> findByEmail(String email);
}
