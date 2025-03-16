package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.owner.RoleType;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Roles,Long> {
Optional<Roles> findByRole(String role);
}
