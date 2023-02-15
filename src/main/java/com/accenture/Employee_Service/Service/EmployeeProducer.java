package com.accenture.Employee_Service.Service;

import com.accenture.Employee_Service.model.Employee;
import com.accenture.Employee_Service.repository.EmpRepo;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class EmployeeProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProducer.class);
    private NewTopic topic;

    @Autowired
    private EmpRepo employeeRepo;

    @Autowired
    private KafkaTemplate<String, Employee> kafkaTemplate;

    public EmployeeProducer(NewTopic topic, KafkaTemplate<String, Employee> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String empId){
        Employee employee = employeeRepo.findById(empId).get();
        LOGGER.info(String.format("Order Event => %s", employee.toString()));

        Message<Employee> message = MessageBuilder.withPayload(employee)
                .setHeader(KafkaHeaders.TOPIC ,topic.name())
                .build();
        kafkaTemplate.send(message);
    }
}
