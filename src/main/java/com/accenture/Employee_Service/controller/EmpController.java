package com.accenture.Employee_Service.controller;
import com.accenture.Employee_Service.KafkaProducer.KafkaMessageProducer;
import com.accenture.Employee_Service.Service.EmpService;
import com.accenture.Employee_Service.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/employee")
public class EmpController {
    @Autowired
    KafkaMessageProducer kafkaMessageProducer;
    @Autowired
    EmpService empService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public void setEmployee(@RequestBody Employee employee){
        this.empService.setEmployee(employee);
    }
    @PostMapping("/message")
    public String postMessage(@RequestBody String message){
        kafkaMessageProducer.sendMessage(message);
        return "Message Published";
    }
    @GetMapping("/{empId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmployee(@PathVariable("empId") String empId){
        return this.empService.getEmployee(empId);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> getAllEmployees() {
        return this.empService.getAllEmployees();
    }


}
