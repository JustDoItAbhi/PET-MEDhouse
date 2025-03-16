package com.pet.house.pethouse.start.services.ownerservice;

import com.pet.house.pethouse.exceptions.OwnerNotExsitsException;
import com.pet.house.pethouse.exceptions.RoleNotExsists;
import com.pet.house.pethouse.start.dtos.authentication.LoginRequestDto;
import com.pet.house.pethouse.start.dtos.authentication.Signup;
import com.pet.house.pethouse.start.dtos.requestdtos.AddressRequestDto;
import com.pet.house.pethouse.start.dtos.requestdtos.OwnerRequestDto;
import com.pet.house.pethouse.start.dtos.response.OwnerResponseDto;
import com.pet.house.pethouse.start.entity.owner_pet.owner.*;
import com.pet.house.pethouse.start.mappers.AuthenticationMapper;
import com.pet.house.pethouse.start.repositories.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerServiceImpl implements OwnerService {
private OwnerRepository ownerRepository;
private PetRespository petRespository;
private AddressRepository addressRepository;
private BCryptPasswordEncoder passwordEncoder;
private AppointmentRepository appointmentRepository;
private VetRepository vetRepository;
private RoleRepository roleRepository;
private HashMap<String,OwnerResponseDto>map=new HashMap<>();

    public OwnerServiceImpl(OwnerRepository ownerRepository, PetRespository petRespository, AddressRepository addressRepository, BCryptPasswordEncoder passwordEncoder,
                            AppointmentRepository appointmentRepository, VetRepository vetRepository, RoleRepository roleRepository) {
        this.ownerRepository = ownerRepository;
        this.petRespository = petRespository;
        this.addressRepository = addressRepository;
        this.passwordEncoder = passwordEncoder;
        this.appointmentRepository = appointmentRepository;
        this.vetRepository = vetRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public OwnerResponseDto signup(Signup dto) {

        // provide email verification
        List<Owner>ownerList=new ArrayList<>();
        Owner owner=new Owner();
        if(map.containsKey(dto.getOwnerEmail())){
            return map.get(AuthenticationMapper.fromEntity(owner));
        }
        owner.setOwnerName(dto.getOwnerName());
        owner.setEmail(dto.getOwnerEmail());
        owner.setPhoneNumber(dto.getPhoneNumber());
        owner.setPassword(passwordEncoder.encode(dto.getPassword()));
        List<Roles>rolesList=new ArrayList<>();
        for(String role: dto.getRoles()){
            Optional<Roles> roles=roleRepository.findByRole(role);
            if(roles.isEmpty()){
                throw new RoleNotExsists("PLEASE CHECK THE ROLE error in role entity "+dto.getRoles());
            }
            Roles roles1=roles.get();
            roles1.setOwnerList(ownerList);
            rolesList.add(roles1);
            roleRepository.save(roles1);
        }

        owner.setRolesList(rolesList);
        List<Addresses>addressesList=new ArrayList<>();
        for(AddressRequestDto dto1:dto.getAddressesList()) {
            Addresses addresses = new Addresses();
            addresses.setCity(dto1.getCity());
            addresses.setCountry(dto1.getCountry());
            addresses.setStreet(dto1.getStreet());
            addresses.setHouseNumber(dto1.getHouseNumber());
            addresses.setPostalCode(dto1.getPostalCode());
            addressesList.add(addresses);
            addressRepository.save(addresses);
        }
        owner.setAddressesList(addressesList);

        map.put("email",AuthenticationMapper.fromEntity(owner));
        ownerRepository.save(owner);
        ownerList.add(owner);
        return AuthenticationMapper.fromEntity(owner);
    }

    @Override
    public OwnerResponseDto login(LoginRequestDto dto) {
     Optional<Owner>existingOwner=ownerRepository.findByEmail(dto.getOwnerEmail());
     if(existingOwner.isEmpty()){
         throw new OwnerNotExsitsException("PLEASE SIGN UP "+dto.getOwnerEmail());
     }
     if(!passwordEncoder.matches(dto.getPassword(),existingOwner.get().getPassword())){
         throw new OwnerNotExsitsException("INCORRECT PASSWORD "+dto.getPassword());
     }
        System.out.println(map.get(AuthenticationMapper.fromEntity(existingOwner.get())));
        return AuthenticationMapper.fromEntity(existingOwner.get());
    }

    @Override
    public OwnerResponseDto getByEmail(String email) {
        Optional<Owner>existingOwner=ownerRepository.findByEmail(email);
        if(existingOwner.isEmpty()){
            throw new OwnerNotExsitsException("PLEASE SIGN UP "+email);
        }
        return AuthenticationMapper.fromEntity(existingOwner.get());
    }

    @Override
    public OwnerResponseDto getOwnerById(long id) {
        Optional<Owner>existingOwner=ownerRepository.findById(id);
        if(existingOwner.isEmpty()){
            throw new OwnerNotExsitsException("PLEASE SIGN UP "+id);
        }
        return AuthenticationMapper.fromEntity(existingOwner.get());

    }

    @Override
    public OwnerResponseDto createOwner(OwnerRequestDto dto) {
//        String petProdblem="";
//        Owner owner=new Owner();
//        owner.setOwnerName(dto.getOwnerName());
//        owner.setOwnerEmail(dto.getOwnerEmail());
//        owner.setCreatedAt(LocalDateTime.now());
//        owner.setPassword(passwordEncoder.encode(dto.getPassword()));
//        ownerRepository.save(owner);
//        List<Addresses>addressesList=new ArrayList<>();
//        for(AddressRequestDto dto1:dto.getAddressesList()) {
//            Addresses addresses = new Addresses();
//            addresses.setCity(dto1.getCity());
//            addresses.setCountry(dto1.getCountry());
//            addresses.setStreet(dto1.getStreet());
//            addresses.setHouseNumber(dto1.getHouseNumber());
//            addresses.setPostalCode(dto1.getPostalCode());
//            addresses.setOwner(owner);
//            addressesList.add(addresses);
//            addressRepository.save(addresses);
//        }
//        owner.setAddressesList(addressesList);
//        List<Pets>petsList=new ArrayList<>();
//        for(PetRequestDto dto1:dto.getPetRequestDtos()){
//            Pets pets=new Pets();
//            pets.setOwner(owner);
//            pets.setPetName(dto1.getPetName());
//            pets.setPetBread(dto1.getPetBread());
//            pets.setPetHistory(dto1.getPetHistory());
//            pets.setPetProblems(dto1.getPetProblems());
//            if(dto1.getPetType().equals(pets.getPetType())) {
//                pets.setPetType(dto1.getPetType());
//                petProdblem=dto1.getPetProblems();
//            }
//            pets.setAge(dto1.getAge());
//            petRespository.save(pets);
//        }
//        owner.setPetsList(petsList);
//        List<Appointments>appointmentsList=new ArrayList<>();
//        for(AppointmentsRequestDto dto1: dto.getAppointmentsList()){
//            Appointments appointments=new Appointments();
////            appointments.setOwner(owner);
//            appointments.setAppointmentDate(dto1.getAppointmentDate());
//            appointments.setStatus(AppointmentsStatus.BOOKED);
//            appointments.setPets(petsList.getFirst());
//
//            appointmentsList.add(appointments);
//
//            Vets vets1=vetRepository.findById(dto1.getVetId()).orElseThrow(
//                    ()->  new RuntimeException("vet not found"+ dto1.getVetId()));
////            vets1.setAppointmentsList(appointmentsList);
//            vets1.setAppointmentsList(appointmentsList);
//
//            VetMapper.fromEntity(vets1);
//
//            vetRepository.save(vets1);
//            appointmentRepository.save(appointments);
//        }
//        owner.setAppointmentsList(appointmentsList);
//
//        ownerRepository.save(owner);
//
//

        return null;
    }


}
