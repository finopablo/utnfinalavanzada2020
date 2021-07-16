package edu.utn.FinalAvanzada.controller;


import edu.utn.FinalAvanzada.model.City;
import edu.utn.FinalAvanzada.model.Employee;
import edu.utn.FinalAvanzada.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @PostMapping
    public ResponseEntity<City> add(@RequestBody City city) {
        City savedCity = cityService.save(city);
        return ResponseEntity.created(URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().build() + "/" + savedCity.getIata_code())).body(savedCity);
    }
}
