package com.pet.house.pethouse.kafka.appointments;

import com.pet.house.pethouse.kafka.KafkaConstrains;
import com.pet.house.pethouse.kafka.OwnerDto;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaAppointConumerFactory {
    @Bean
    public ConsumerFactory<String, AppointmentEmailDto> appointmentConsumerFactory(){
        Map<String,Object> map=new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstrains.HOST);
        map.put(ConsumerConfig.GROUP_ID_CONFIG,KafkaConstrains.GROUP_ID);
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        map.put(JsonDeserializer.TRUSTED_PACKAGES,("*"));
        return new DefaultKafkaConsumerFactory<>(map,new StringDeserializer(),new JsonDeserializer<>());
    }
    @Bean(name = "appointment")
    public ConcurrentKafkaListenerContainerFactory<String,AppointmentEmailDto> kafkaListenerAppointmentFactory(){
        ConcurrentKafkaListenerContainerFactory<String,AppointmentEmailDto>factory=new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(appointmentConsumerFactory());
        return factory;
    }
}
