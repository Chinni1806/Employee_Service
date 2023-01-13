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
    public Employee insert(Employee employee) {
        return empRepo.save(employee);
    }
    public Optional<Employee> getEmpDataById(String id) {
        return empRepo.findById(id);
    }
    public List<Employee> EmployeeList() {
        return empRepo.findAll();
    }


}
