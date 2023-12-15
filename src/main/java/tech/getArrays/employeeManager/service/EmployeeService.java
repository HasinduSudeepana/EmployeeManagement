package tech.getArrays.employeeManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getArrays.employeeManager.exception.UserNotFoundException;
import tech.getArrays.employeeManager.model.Employee;
import tech.getArrays.employeeManager.repo.EmployeeRepo;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;    // The EmployeeRepo field is a repository interface for performing CRUD operations on Employee entities.


    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {       // create a constructor
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee){
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee findEmployeeById(Long id) {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id "+id+" was not found"));
    }

    public void deleteEmployee(Long id){
        employeeRepo.deleteEmployeeById(id);
    }
}
