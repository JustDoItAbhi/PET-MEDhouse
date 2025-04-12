package com.pet.house.pethouse.kafka.appointments;

import com.pet.house.pethouse.kafka.KafkaConstrains;
import com.pet.house.pethouse.kafka.OwnerDto;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;
@Configuration
public class KafkaProducerAppointmentFactory {
    @Bean
    public ProducerFactory<String, AppointmentEmailDto> appointmentProducerFactory(){
        Map<String,Object> map=new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstrains.HOST);
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory(map,new StringSerializer(),new JsonSerializer());
    }
    @Bean(name = "appointmentKafkaTemplate")
    public KafkaTemplate<String,AppointmentEmailDto> kafkaTemplate(ProducerFactory<String,AppointmentEmailDto> appointmentproducerFactory) {
        return new KafkaTemplate<>(appointmentProducerFactory());
    }
}
