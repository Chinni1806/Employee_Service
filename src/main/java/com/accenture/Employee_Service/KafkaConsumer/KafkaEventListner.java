package com.accenture.Employee_Service.KafkaConsumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class KafkaEventListner {
    @KafkaListener(topics = "${Kafka.topic}")
    public void listen(Message<String> message){
        String res=message.getPayload();
        System.out.println(res);

    }

}
