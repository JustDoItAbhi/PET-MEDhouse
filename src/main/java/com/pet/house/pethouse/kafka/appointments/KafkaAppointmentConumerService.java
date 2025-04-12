package com.pet.house.pethouse.kafka.appointments;

import com.pet.house.pethouse.kafka.KafkaConstrains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAppointmentConumerService {
    @Autowired
    private AppointmentEmailService emailService;

    @KafkaListener(topics = KafkaConstrains.Topic, groupId = KafkaConstrains.GROUP_ID)
    public void consumeMessage(AppointmentEmailDto dto1) {
        System.out.println("Message received: " + dto1.getOwnerName());

        // Send welcome email after the Kafka message is consumed
        String appointmentMessage =
                "Dear " + dto1.getOwnerName() + ",\n\n" +
                        "Your appointment for your pet, " + dto1.getPetName() + ", has been successfully booked. Below are the details of the appointment:\n\n" +

                        "Appointment Details:\n" +
                        "-----------------------------------------\n" +
                        "Date: " + dto1.getDate() + "\n" +
                        "Status: " + dto1.getStatus() + "\n\n" +

                        "Pet Details:\n" +
                        "-----------------------------------------\n" +
                        "Pet Name: " + dto1.getPetName() + "\n" +
                        "Pet Breed: " + dto1.getPetBread() + "\n" +
                        "Problem with Pet: " + dto1.getProblemWithPet() + "\n" +
                        "History of Pet: " + dto1.getHistoryOfPet() + "\n\n" +

                        "Vet Details:\n" +
                        "-----------------------------------------\n" +
                        "Vet Name: " + dto1.getVetName() + "\n" +
                        "Vet Specialization: " + dto1.getSpecialization() + "\n" +
                        "Specialization Description: " + dto1.getSpecializationDescription() + "\n" +
                        "Vet Email: " + dto1.getVetEmail() + "\n\n" +

                        "We hope this appointment will be helpful for your pet's well-being. If you have any questions or need to reschedule, please do not hesitate to contact us.\n\n" +
                        "Best regards,\n" +
                        "Pet House Team";

        emailService.sendAppointmentEmail(dto1.getOwnerEmail(), dto1.getOwnerName(),appointmentMessage);
    }
}
