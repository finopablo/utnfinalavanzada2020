package edu.utn.FinalAvanzada.controller;


import edu.utn.FinalAvanzada.model.City;
import edu.utn.FinalAvanzada.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

    @Autowired
    private Connection conn;

    @GetMapping("cities")
    public ResponseEntity<List<City>> getCities() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM cities");
            List<City> cities = new ArrayList<>();
            while (rs.next()) {
                cities.add(City.builder().code(rs.getString("iata_code")).name(rs.getString("city_name")).build());
            }
            return ResponseEntity.ok(cities);

        } catch (SQLException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("employees")
    public ResponseEntity<List<Employee>> getEmployees() {
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM employees e inner join cities c on e.city_iata_code = c.iata_code");
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                employees.add(Employee.builder().id(rs.getInt("id")).name(rs.getString("name")).lastName("last_name").age(rs.getInt("age")).city(
                        City.builder().code(rs.getString("iata_code")).name(rs.getString("city_name")).build()).build());
            }
            return ResponseEntity.ok(employees);
        } catch (SQLException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
