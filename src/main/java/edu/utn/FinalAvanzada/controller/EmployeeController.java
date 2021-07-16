package edu.utn.FinalAvanzada.controller;

import edu.utn.FinalAvanzada.exceptions.NotFoundException;
import edu.utn.FinalAvanzada.model.Employee;
import edu.utn.FinalAvanzada.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(value = "/range", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> getEmployeeByAgeRange(@RequestParam("to") int to,
                                                                @RequestParam("from") int from){

        List<Employee> employeeList = this.employeeService.getEmployeeByAgeRange(from, to);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        Employee employeeToSave = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(employeeToSave, HttpStatus.OK);
    }


}
