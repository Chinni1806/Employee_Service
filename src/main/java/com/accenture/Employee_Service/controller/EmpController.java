package com.accenture.Employee_Service.controller;
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
    EmpService empService;
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee createEmployee(@RequestBody Employee employee){
        return empService.insert(employee);
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Employee> getEmpDataById(@PathVariable("id") String Id){
        return empService.getEmpDataById(Id);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> EmployeeList() {
        return empService.EmployeeList();
    }


}
