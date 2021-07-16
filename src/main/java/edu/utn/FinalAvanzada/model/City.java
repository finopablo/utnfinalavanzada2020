package edu.utn.FinalAvanzada.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    @Column(name = "iata_code")
    String code;

    @Column(name = "city_name")
    String name;

    @OneToMany(mappedBy = "city")
    List<Employee> employees;
}
