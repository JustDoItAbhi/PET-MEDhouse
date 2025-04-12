package com.pet.house.pethouse.kafka;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private EmailService emailService;

    public KafkaConsumerService(EmailService emailService) {
        this.emailService = emailService;
    }

    @KafkaListener(topics = KafkaConstrains.Topic, groupId = KafkaConstrains.GROUP_ID)
    public void consumeMessage(OwnerDto ownerDto) {
        System.out.println("Message received: " + ownerDto.getOwnerName());

        // Send welcome email after the Kafka message is consumed
        String message = "YOUR SUCCESSFULLY SIGNUP NOW PLEASE LOGIN WITH \n\nhttp://localhost:8080/book/login";
        emailService.mailSender(ownerDto.getEmail(), ownerDto.getOwnerName(), message);
    }
}
