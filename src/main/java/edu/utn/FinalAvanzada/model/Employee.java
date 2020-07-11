package edu.utn.FinalAvanzada.model;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Employee {
    int id;
    String name;
    String  lastName;
    int age;
    City city;
}
