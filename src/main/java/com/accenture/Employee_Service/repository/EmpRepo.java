package com.accenture.Employee_Service.repository;

import com.accenture.Employee_Service.model.Employee;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo extends CouchbaseRepository<Employee,String> {

}
