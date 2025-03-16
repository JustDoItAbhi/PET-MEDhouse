package com.pet.house.pethouse.start.services.appointments;

import com.pet.house.pethouse.exceptions.AppointmentAlreadyBooked;
import com.pet.house.pethouse.exceptions.OwnerNotExsitsException;
import com.pet.house.pethouse.exceptions.VetNotFoundException;
import com.pet.house.pethouse.start.dtos.requestdtos.AppointmentRequestDto;
import com.pet.house.pethouse.start.dtos.response.AppointmentsResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Owner;
import com.pet.house.pethouse.start.entity.owner_pet.owner.Pets;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Appointments;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.AppointmentsStatus;
import com.pet.house.pethouse.start.entity.owner_pet.specialist.Vets;
import com.pet.house.pethouse.start.mappers.AppointmentMapper;
import com.pet.house.pethouse.start.repositories.*;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class AppointmentServicesImpl implements AppointmentServices{
    private OwnerRepository ownerRepository;
    private PetRespository petRespository;
    private AppointmentRepository appointmentRepository;
    private VetRepository vetRepository;


    public AppointmentServicesImpl(OwnerRepository ownerRepository, PetRespository petRespository,
                                   AppointmentRepository appointmentRepository, VetRepository vetRepository) {
        this.ownerRepository = ownerRepository;
        this.petRespository = petRespository;
        this.appointmentRepository = appointmentRepository;
        this.vetRepository = vetRepository;
    }
    @Override
    public AppointmentsResponseDto createAppointment(AppointmentRequestDto dto) {
        Appointments appointments=new Appointments();
        Optional<Appointments>existingAppointments=appointmentRepository.findByAppointmentDate(dto.getAppointmentDate());
        if(existingAppointments.isPresent()){
            throw new AppointmentAlreadyBooked("THERE IS NO APPOINTMENT ON THIS DATE ");
        }

        appointments.setAppointmentDate(dto.getAppointmentDate());
        Optional<Owner>savedOwner=ownerRepository.findByEmail(dto.getOwnerEmail());
        if(savedOwner.isEmpty()){
            throw new OwnerNotExsitsException("PLEASE SIGN UP AS OWNER "+dto.getOwnerEmail());
        }
        Owner owner= savedOwner.get();
        appointments.setOwner(owner);
        Optional<Pets>savedPets=petRespository.findByOwnerId(savedOwner.get().getId());
        if(savedPets.isEmpty()){
            throw new OwnerNotExsitsException("PET CANT FIND OWNER BY ID "+owner.getId());
        }
        appointments.setPets(savedPets.get());
        Optional<Vets>savedVets=vetRepository.findBySpecializationName(dto.getVetSpeacialization());
        if(savedPets.isEmpty()){
            throw new VetNotFoundException("VET CANT FIND OWNER BY SPACIALIZATION "+dto.getVetSpeacialization());
        }
        appointments.setVetsList(savedVets.get());
        appointments.setStatus(AppointmentsStatus.BOOKED);
        appointmentRepository.save(appointments);
        return AppointmentMapper.fromEntity(appointments);
    }

    @Override
    public boolean deleteAppointment(long id) {
        appointmentRepository.deleteById(id);
        return true;
    }
}
