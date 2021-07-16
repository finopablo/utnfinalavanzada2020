package edu.utn.FinalAvanzada.service;

import edu.utn.FinalAvanzada.Repository.EmployeeRepository;
import edu.utn.FinalAvanzada.exceptions.NotFoundException;
import edu.utn.FinalAvanzada.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Employee not found"));
    }

    public Employee updateEmployee(Employee employee){

        Employee employee1 = this.getEmployeeById(employee.getId());
        return Employee.builder()
                .name(employee.getName())
                .lastName(employee.getLastName())
                .age(employee.getAge())
                .city(employee.getCity())
                .build();
    }

    public List<Employee> getEmployeeByAgeRange(int from, int to) {

        List<Employee> employeeList = this.employeeRepository.findByAgeRange(from, to);
        if (employeeList.isEmpty()){
            throw new NotFoundException("Employees with that range age not found");
        }
        return employeeList;
    }
}
