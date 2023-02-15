package com.accenture.Employee_Service.controller;

import com.accenture.Employee_Service.Service.EmployeeProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka/employees")
public class KafkaEmpController {
    @Autowired
    private EmployeeProducer employeeProducer;

    @GetMapping("/{empId}")
    @ResponseStatus(HttpStatus.OK)
    public void getEmployee(@PathVariable("empId") String empId){

        employeeProducer.sendMessage(empId);
    }

}
