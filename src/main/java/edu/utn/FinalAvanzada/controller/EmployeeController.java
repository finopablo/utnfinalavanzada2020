package edu.utn.FinalAvanzada.controller;

import edu.utn.FinalAvanzada.model.Employee;
import edu.utn.FinalAvanzada.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/city/{code}")
    public ResponseEntity<List<Employee>> findEmployeesByCity(
            @PathVariable String code,
            @RequestParam(defaultValue = "0") Integer pageNumber,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        List<Employee> employees = employeeService.findEmployeesByCity(code, PageRequest.of(pageNumber, pageSize));

        if (employees.isEmpty()) {
            return new ResponseEntity<>(employees, HttpStatus.NOT_FOUND);
        } else {
            return ResponseEntity.ok(employees);
        }
    }
}
