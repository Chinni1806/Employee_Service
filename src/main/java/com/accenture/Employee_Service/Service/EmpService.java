package com.accenture.Employee_Service.Service;
import com.accenture.Employee_Service.model.Employee;
import com.accenture.Employee_Service.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class EmpService {
    @Autowired
    EmpRepo empRepo;
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }
    public Optional<Employee> getEmployee(String empId){
        return empRepo.findById(empId);
    }
    public void setEmployee(Employee employee){
        empRepo.save(employee);
    }


}
