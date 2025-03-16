package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.owner.Addresses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Addresses,Long> {
}
