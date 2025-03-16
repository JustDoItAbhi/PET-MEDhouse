package com.pet.house.pethouse.start.repositories;

import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointments,Long> {

//    @Query("SELECT a from Appointments as a where a.appointments.pets_id=:id")
//    Optional<Appointments> getAppointmentByPetId(@Param("id")long id);

    Optional<Appointments> findByAppointmentDate(Date date);
}
