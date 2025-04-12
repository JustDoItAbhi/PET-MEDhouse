package com.pet.house.pethouse.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
private JavaMailSender mailSender;

public String mailSender(String to,String name,String mesasge){
    SimpleMailMessage message=new SimpleMailMessage();
    message.setFrom("arvinderpalsingh2321@gmail.com");
    message.setTo(to);
    message.setSubject("WELCOME TO PET HOUSE"+name);
    message.setText(mesasge);
    try{
        mailSender.send(message);
       return ("MAIL SENT SUCCESSFULLY TO: "+to);
    } catch (MailException e) {
       return "FAIL TO SEND EMAIL "+to;
    }
}
}
