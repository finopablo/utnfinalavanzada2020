package edu.utn.FinalAvanzada.service;

import edu.utn.FinalAvanzada.model.Employee;
import edu.utn.FinalAvanzada.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findEmployeesByCity(String code, Pageable pageable) {
        return employeeRepository.findEmployeeByCity(code, pageable);
    }
}
